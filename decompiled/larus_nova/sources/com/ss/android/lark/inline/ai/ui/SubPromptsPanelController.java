package com.ss.android.lark.inline.ai.ui;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.inline.ai.ui.prompts.PromptsRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class SubPromptsPanelController {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f427472g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wlb.h f427473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final wlb.e f427474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FragmentActivity f427475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Triple<View, InlineAIDragView, Function0<Unit>>> f427476d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PromptsRecyclerView f427477e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public InlineAIDragView f427478f;

    public static final class a {
    }

    static {
    }

    public final boolean b() {
        if (((ArrayList) this.f427476d).size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final FragmentActivity getActivity() {
        return this.f427475c;
    }

    public SubPromptsPanelController(wlb.h r100, wlb.e r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f427473a = r100;
        this.f427474b = r101;
        this.f427475c = r100.getActivity();
        this.f427476d = new ArrayList();
    }

    public final void a(boolean r100, boolean r101) {
        if (r100 == false) goto L7;
        ArrayList r102 = new ArrayList();
        r102.addAll(this.f427476d);
        ((ArrayList) this.f427476d).clear();
        Iterator r103 = r102.iterator();
    L5:
        if (r103.hasNext() == false) goto L13;
        final Triple r104 = (Triple) r103.next();
        ((InlineAIDragView) r104.getSecond()).g(r101, new SubPromptsPanelController$hideInternal$1$1(this, r104));
        goto L5
    L13:
        return;
    L7:
        final Triple r105 = (Triple) CollectionsKt.removeLastOrNull(this.f427476d);
        if (r105 == null) goto L12;
        ((InlineAIDragView) r105.getSecond()).g(r101, new SubPromptsPanelController$hideInternal$2$1(this, r105));
        return;
    }
}
