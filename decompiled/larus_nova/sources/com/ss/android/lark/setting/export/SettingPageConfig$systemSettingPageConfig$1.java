package com.ss.android.lark.setting.export;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import d5c.b;
import d5c.c;
import d5c.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "", "Lcom/ss/android/lark/setting/export/v2/SettingItem;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class SettingPageConfig$systemSettingPageConfig$1 extends Lambda implements Function1<List<c>, Unit> {
    public static final SettingPageConfig$systemSettingPageConfig$1 INSTANCE = null;

    static {
        INSTANCE = new SettingPageConfig$systemSettingPageConfig$1();
    }

    public SettingPageConfig$systemSettingPageConfig$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<c> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$settingConfig");
        b r101 = new b();
        r101.a(new d());
        r101.a(new d());
        r100.add(r101);
        b r102 = new b();
        r102.a(new d());
        r102.a(new d());
        r102.a(new d());
        r102.a(new d());
        r102.a(new d());
        r102.a(new d());
        r102.a(new d());
        r102.a(new d());
        r102.a(new d());
        r100.add(r102);
        b r103 = new b();
        r103.a(new d());
        r103.a(new d());
        r100.add(r103);
        b r104 = new b();
        r104.a(new d());
        r104.a(new d());
        r104.a(new d());
        r100.add(r104);
        r100.add(new d());
        r100.add(new d());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<c> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
