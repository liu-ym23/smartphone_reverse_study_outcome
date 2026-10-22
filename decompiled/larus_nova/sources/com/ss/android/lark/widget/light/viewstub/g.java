package com.ss.android.lark.widget.light.viewstub;

import android.text.Editable;
import android.text.TextWatcher;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class g implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextViewSpanViewContainer f446341a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public g(TextViewSpanViewContainer r100) {
        this.f446341a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        if (r100 != null) goto L5;
        TextViewSpanViewContainer r101 = this.f446341a;
        int r102 = TextViewSpanViewContainer.f446317k;
        r101.removeAllViews();
        ((LinkedHashMap) r101.f446318a).clear();
        r101.f446319b.clear();
        return;
    L5:
        if (r100.getSpanStart(this.f446341a.f446326i) != (-1)) goto L7;
        r100.setSpan(this.f446341a.f446326i, 0, r100.length(), 33);
    L7:
        TextViewSpanViewContainer r103 = this.f446341a;
        Set<Object> r104 = r103.f446324g;
        r104.clear();
        CollectionsKt.addAll(r104, r100.getSpans(0, r100.length(), Object.class));
        ArrayList r105 = (ArrayList) r103.f446325h;
        r105.clear();
        Iterator r106 = ((LinkedHashMap) r103.f446318a).entrySet().iterator();
    L9:
        if (r106.hasNext() == false) goto L13;
        ViewHolderSpan r107 = (ViewHolderSpan) ((Map.Entry) r106.next()).getKey();
        if (r104.contains(r107) == true) goto L9;
        r105.add(r107);
        goto L9
    L13:
        Iterator r108 = r105.iterator();
    L15:
        if (r108.hasNext() == false) goto L17;
        Object r109 = r108.next();
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type com.ss.android.lark.widget.light.viewstub.ViewHolderSpan");
        r103.d((ViewHolderSpan) r109);
        goto L15
    L17:
        Log.d("SpanView", "checkAndChangeSpans: wille remove span size is " + r105.size());
        r105.clear();
        Iterator<Object> r110 = r104.iterator();
    L19:
        if (r110.hasNext() == false) goto L21;
        r103.a(r100, r110.next());
        goto L19
    L21:
        r104.clear();
        this.f446341a.c();
    }
}
