package com.ss.android.ugc.tools.view.widget.state;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class b extends FrameLayout implements a<CommonUiState> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<CommonUiState, View> f455141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<CommonUiState, Function1<ViewGroup, View>> f455142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CommonUiState f455143c;

    public b() {
        throw null;
    }

    /* JADX INFO: renamed from: getState, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Enum m8707getState() {
        return getState();
    }

    public CommonUiState getState() {
        return this.f455143c;
    }

    public void setState(CommonUiState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Map<CommonUiState, View> r101 = this.f455141a;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        View r103 = (View) r102.get(this.f455143c);
        if (r103 == null) goto L5;
        r103.setVisibility(8);
    L5:
        this.f455143c = r100;
        Function1 r104 = (Function1) ((LinkedHashMap) this.f455142b).get(r100);
        if (r104 != null) goto L8;
        return;
    L8:
        if (this.f455141a.containsKey(this.f455143c) == true) goto L10;
        View r105 = (View) r104.invoke(this);
        r105.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(r105);
        this.f455141a.put(this.f455143c, r105);
    L10:
        Map<CommonUiState, View> r106 = this.f455141a;
        LinkedHashMap r107 = (LinkedHashMap) r106;
        View r108 = (View) r107.get(this.f455143c);
        if (r108 == null) goto L15;
        r108.setVisibility(0);
        return;
    }

    @Override // com.ss.android.ugc.tools.view.widget.state.a
    public /* bridge */ /* synthetic */ void setState(Enum r100) {
        setState((CommonUiState) r100);
    }

    public b(Context r100, Map r101, CommonUiState r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "providers");
        Intrinsics.checkNotNullParameter(r102, "initState");
        super(r100, null);
        this.f455141a = new LinkedHashMap();
        LinkedHashMap r103 = new LinkedHashMap();
        this.f455142b = r103;
        r103.putAll(r101);
        this.f455143c = r102;
    }
}
