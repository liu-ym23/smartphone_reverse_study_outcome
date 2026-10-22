package com.larus.ugc.feed.impl.detail.ability;

import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.im.internal.delegate.c0;
import com.larus.platform.api.creation.UserCreation;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes31.dex */
public final class CreationDetailBottomToolsAbilityImpl implements h0a.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f374749f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f374750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t0a.a f374751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l0a.a f374752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i0a.a f374753d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i0a.b f374754e;

    public static final class a {
    }

    static {
    }

    public final Object c(Continuation<? super Unit> r100) {
        if ((r100 instanceof CreationDetailBottomToolsAbilityImpl$toggleLike$1) == false) goto L7;
        CreationDetailBottomToolsAbilityImpl$toggleLike$1 r101 = (CreationDetailBottomToolsAbilityImpl$toggleLike$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        boolean r106 = r101.Z$0;
        String r107 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L23:
        boolean r108 = ((Boolean) r103).booleanValue();
        String r109 = r107;
    L26:
        if (r108 == false) goto L28;
        c0 r110 = c0.f348199b;
        StringBuilder r111 = new StringBuilder("toggleLike success, like=");
        r111.append(!r106);
        r110.i("BottomToolsAbilityImpl", r111.toString());
    L30:
        return Unit.INSTANCE;
    L28:
        c0 r112 = c0.f348199b;
        StringBuilder r113 = new StringBuilder("toggleLike failed, like=");
        r113.append(!r106);
        r113.append(", id=");
        r113.append(r109);
        r112.e("BottomToolsAbilityImpl", r113.toString());
        goto L30
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        boolean r114 = this.f374751b.a().f501271b;
        this.f374751b.update(new com.larus.ugc.feed.impl.detail.ability.a());
        r109 = this.f374751b.a().f501270a;
        i0a.b r115 = this.f374754e;
        if (r115 == null) goto L17;
        j0a.b r116 = r115.f487909a;
    L18:
        if (r116 == null) goto L24;
        r101.L$0 = r109;
        r101.Z$0 = r114;
        r101.label = 1;
        Object r117 = r116.b(r109, !r114);
        if (r117 != r104) goto L22;
        return r104;
    L22:
        r106 = r114;
        r103 = r117;
        r107 = r109;
        goto L23
    L24:
        r106 = r114;
        r108 = false;
        goto L26
    L17:
        r116 = null;
    L7:
        r101 = new CreationDetailBottomToolsAbilityImpl$toggleLike$1(this, r100);
        goto L8
    }

    public final void b(final UserCreation r100, boolean r110) {
        this.f374751b.update(new b(r100));
        if (r100 == null) goto L5;
        String r101 = r100.f364987a;
    L6:
        if (r101 != null) goto L8;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == true) goto L15;
        BuildersKt.launch$default(this.f374750a, Dispatchers.getDefault(), null, new CreationDetailBottomToolsAbilityImpl$initData$2(this, r101, r110, null), 2, null);
        return;
    L15:
        return;
    L8:
        if (r101.length() == 0) goto L11;
        r102 = false;
        goto L12
    L5:
        r101 = null;
        goto L6
    }

    public CreationDetailBottomToolsAbilityImpl(LifecycleCoroutineScope r100, t0a.a r101, l0a.a r102) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "stateHolder");
        Intrinsics.checkNotNullParameter(r102, com.bytedance.android.ec.core.event.a.KEY_TRACKER);
        this.f374750a = r100;
        this.f374751b = r101;
        this.f374752c = r102;
    }
}
