package com.ss.android.lark.keyboard.edittext2.edittors;

import android.text.SpannableStringBuilder;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public class a extends BaseFunctionEditor<hob.c> implements com.ss.android.lark.keyboard.edittext2.base.c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C5088a f428974e = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Class<? extends hob.c>, com.ss.android.lark.keyboard.edittext2.edittors.at.c<? extends hob.c>> f428975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f428976d;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.edittext2.edittors.a$a, reason: collision with other inner class name */
    public static final class C5088a implements com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC5085a<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.keyboard.edittext2.base.d f428977a;

        @Override // com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC5085a
        public final Class<a> a() {
            return this.f428977a.f428961a;
        }

        public C5088a() {
            this.f428977a = new com.ss.android.lark.keyboard.edittext2.base.d(a.class);
        }
    }

    static {
        f428974e = new C5088a();
    }

    public a() {
        this.f428975c = new LinkedHashMap();
        W(CollectionsKt.listOf(new com.ss.android.lark.keyboard.edittext2.edittors.at.common.b()));
    }

    public void V() {
        int r100 = com.ss.android.lark.keyboard.edittext2.utils.e.c(com.ss.android.lark.keyboard.edittext2.base.c.a.a(this));
        if (r100 < 0) goto L6;
        com.ss.android.lark.keyboard.edittext2.base.c.a.a(this).getEditableText().delete(r100, r100 + 1);
        return;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor, com.ss.android.lark.keyboard.edittext2.base.a
    public final void d() {
        this.f428976d = UDColorUtils.getColor(context(), R.color.text_caption);
        Iterator r100 = ((LinkedHashMap) this.f428975c).entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        Map.Entry r101 = (Map.Entry) r100.next();
        ((com.ss.android.lark.keyboard.edittext2.edittors.at.c) r101.getValue()).A(getTarget());
        ((com.ss.android.lark.keyboard.edittext2.edittors.at.c) r101.getValue()).d();
        goto L4
    }

    public void U(com.ss.android.lark.keyboard.edittext2.edittors.at.c<?> r100) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        if (this.f428958a == null) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        r100.A(getTarget());
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void W(List<? extends com.ss.android.lark.keyboard.edittext2.edittors.at.c<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        this.f428975c.clear();
        Iterator<T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        com.ss.android.lark.keyboard.edittext2.edittors.at.c<? extends hob.c> r102 = (com.ss.android.lark.keyboard.edittext2.edittors.at.c) r101.next();
        this.f428975c.put((Class<? extends hob.c>) r102.getType(), r102);
        U(r102);
        goto L4
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public final void S(SpannableStringBuilder r100, hob.c r101, int r102) {
        hob.c r103 = r101;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r103, "data");
        boolean r104 = false;
        if (r103.f486308a.length() != 0) goto L5;
        boolean r105 = true;
    L7:
        if (r105 == false) goto L9;
    L26:
        Log.i("ATEditor", "onInsert: chatter id or chatter name is null. now return");
        return;
    L9:
        if (r103.f486309b.length() != 0) goto L11;
        r104 = true;
    L11:
        if (r104 == true) goto L26;
        if (r102 >= 0) goto L15;
    L25:
        Log.e("ATEditor", "on Insert: start = " + r102 + " is valid. no return");
        return;
    L15:
        if (r102 > r100.length()) goto L25;
        String r106 = "@" + r103.f486309b;
        r100.append(r106);
        Object r107 = ((LinkedHashMap) this.f428975c).get(r103.getClass());
        if ((r107 instanceof com.ss.android.lark.keyboard.edittext2.edittors.at.c) == false) goto L20;
        com.ss.android.lark.keyboard.edittext2.edittors.at.c r108 = (com.ss.android.lark.keyboard.edittext2.edittors.at.c) r107;
    L21:
        if (r108 == null) goto L23;
        r100.setSpan(r108.c(this, r103), r102, r106.length() + r102, 33);
    L24:
        V();
        return;
    L23:
        Log.w("ATEditor", "onInsert: not found atStrategy to handle data, id is " + r103.f486308a);
        goto L24
    L20:
        r108 = null;
        goto L21
    L5:
        r105 = false;
        goto L7
    }
}
