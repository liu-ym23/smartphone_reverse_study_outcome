package com.larus.home.impl.route;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.aweme.api.video.service.VideoFragmentProviderDelegate;
import com.larus.bmhome.BaseHomeTabFragment;
import com.larus.bmhome.chat.ChatDoubleTabFragment;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.immerse.ChatImmersFragment;
import com.larus.home.impl.main.tab.MainTabFragment;
import com.larus.home.impl.main.tab.config.BottomTabConfigManager;
import com.larus.home.impl.view.tab.TabMode;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: classes29.dex */
public final class BottomPermanentFragmentFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.router.c f346031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MainTabFragment f346032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f346033c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/home/impl/route/BottomPermanentFragmentFactory$FragmentType;", "", "<init>", "(Ljava/lang/String;I)V", "TYPE_CHAT", "TYPE_CHAT_DOUBLE_TAB", "TYPE_DOU_YIN_BOT", "TYPE_CHAT_IMMERS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FragmentType extends Enum<FragmentType> {
        public static final FragmentType TYPE_CHAT = null;
        public static final FragmentType TYPE_CHAT_DOUBLE_TAB = null;
        public static final FragmentType TYPE_CHAT_IMMERS = null;
        public static final FragmentType TYPE_DOU_YIN_BOT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FragmentType[] f346034a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f346035b = null;

        public static EnumEntries<FragmentType> getEntries() {
            return f346035b;
        }

        static {
            FragmentType r100 = new FragmentType("TYPE_CHAT", 0);
            TYPE_CHAT = r100;
            FragmentType r101 = new FragmentType("TYPE_CHAT_DOUBLE_TAB", 1);
            TYPE_CHAT_DOUBLE_TAB = r101;
            FragmentType r102 = new FragmentType("TYPE_DOU_YIN_BOT", 2);
            TYPE_DOU_YIN_BOT = r102;
            FragmentType r103 = new FragmentType("TYPE_CHAT_IMMERS", 3);
            TYPE_CHAT_IMMERS = r103;
            FragmentType[] r104 = {r100, r101, r102, r103};
            f346034a = r104;
            f346035b = EnumEntriesKt.enumEntries(r104);
        }

        public static FragmentType[] values() {
            return (FragmentType[]) f346034a.clone();
        }

        public static FragmentType valueOf(String r100) {
            return (FragmentType) r27.a.a(FragmentType.class, r100);
        }

        public FragmentType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a extends FragmentManager.FragmentLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Fragment f346036a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BaseHomeTabFragment f346037b;

        public a(Fragment r100, BaseHomeTabFragment r101) {
            Intrinsics.checkNotNullParameter(r100, "removedFragment");
            Intrinsics.checkNotNullParameter(r101, "curSelectFragment");
            this.f346036a = r100;
            this.f346037b = r101;
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public final void onFragmentViewDestroyed(FragmentManager r100, Fragment r101) {
            Intrinsics.checkNotNullParameter(r100, "fm");
            Intrinsics.checkNotNullParameter(r101, "f");
            super.onFragmentViewDestroyed(r100, r101);
            if (Intrinsics.areEqual(r101, this.f346036a) == false) goto L5;
            FLogger r102 = FLogger.f375446a;
            int r103 = a0.f346060a;
            r102.d("ChatRouterTabInterceptor", "onFragmentViewDestroyed removeChatContainer removedFragment = " + this.f346036a + " curSelectFragment =" + this.f346037b);
            this.f346037b.X90();
        L5:
            this.f346037b.getChildFragmentManager().unregisterFragmentLifecycleCallbacks(this);
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f346038a = null;

        static {
            int[] r100 = new int[FragmentType.values().length];
            r100[FragmentType.TYPE_CHAT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[FragmentType.TYPE_CHAT_DOUBLE_TAB.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[FragmentType.TYPE_DOU_YIN_BOT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[FragmentType.TYPE_CHAT_IMMERS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f346038a = r100;
        }
    }

    public final int c() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(Integer.valueOf(this.f346032b.ba0()));     // Catch: Throwable -> L4
    L6:
        Integer r102 = Integer.valueOf(c7.b(Float.valueOf(56.0f)));
        if (Result.m9455isFailureimpl(r101) == false) goto L10;
        r101 = r102;
    L10:
        return ((Number) r101).intValue();
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.larus.home.impl.route.k] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Fragment b(FragmentType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        int r101 = b.f346038a[r100.ordinal()];
        if (r101 == 1) goto L22;
        if (r101 != 2) goto L7;
        ChatDoubleTabFragment r102 = new ChatDoubleTabFragment();
        r102.f296855o = new i(this);
        r102.f296856p = new j(this);
        return r102;
    L7:
        if (r101 != 3) goto L9;
        Fragment r103 = VideoFragmentProviderDelegate.f294747b.a(new k(this));
        BaseHomeTabFragment r104 = d(null);
        if (r104 == null) goto L19;
        r104.f294908e = true;
    L19:
        this.f346032b.fa0(TabMode.NIGHT);
        return r103;
    L9:
        if (r101 != 4) goto L15;
        ChatImmersFragment r105 = new ChatImmersFragment();
        final BaseHomeTabFragment r106 = d(null);
        if (r106 == null) goto L13;
        r106.f294908e = true;
    L13:
        this.f346032b.fa0(TabMode.NIGHT);
        r105.f303189o = new l(this);
        r105.f303191q = c();
        Function1<? super Bundle, Unit> r107 = new m(this, r106);
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r105.f303190p = r107;
        return r105;
    L15:
        throw new NoWhenBranchMatchedException();
    L22:
        if (BottomTabConfigManager.g() == true) goto L26;
        View r108 = this.f346033c;
        if (r108 == null) goto L26;
        com.larus.utils.e1.o(r108);
    L26:
        ChatFragment r109 = new ChatFragment();
        r109.f296866g = new f(this);
        r109.f296865f = new g(this);
        final BaseHomeTabFragment r110 = d(null);
        Function1<? super Bundle, Unit> r111 = new h(this, r110);
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r109.f296875p = r111;
        return r109;
    }

    public final BaseHomeTabFragment d(MainTabFragment.MainTab r100) {
        BaseHomeTabFragment r101 = this.f346032b.IK(r100);
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        if (r102 == false) goto L13;
        int r103 = this.f346032b.Fu();
        List<Fragment> r104 = this.f346032b.getChildFragmentManager().getFragments();
        if (r104.size() != 0) goto L11;
        return null;
    L11:
        Object r105 = ListProtector.get(r104, r103);
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type com.larus.bmhome.BaseHomeTabFragment");
        return (BaseHomeTabFragment) r105;
    L13:
        return r101;
    L5:
        if (r101.isAdded() == true) goto L7;
        r102 = true;
        goto L7
    }

    public BottomPermanentFragmentFactory(com.bytedance.router.c r100, MainTabFragment r101) {
        Intrinsics.checkNotNullParameter(r101, "mainTabFg");
        this.f346031a = r100;
        this.f346032b = r101;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Context r103 = r101.getContext();     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L5
        Object r104 = Result.m9449constructorimpl(((Activity) r103).findViewById(R.id.main_tab_layout));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r104) == false) goto L10;
        r104 = null;
    L10:
        this.f346033c = (View) r104;
        return;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public final void e(BaseHomeTabFragment r100, Bundle r101) {
        String r102 = r101.getString("argCvsBgImgUrl");
        String r103 = r101.getString("argCvsBgImgColor");
        boolean r104 = r101.getBoolean("argCvsBgImgOpen");
        if (z2.f365865a.chatImmerseEnable() == false) goto L10;
        if (r104 == false) goto L10;
        if (com.larus.utils.o0.d(r102) == false) goto L10;
        if (com.larus.utils.o0.d(r103) == false) goto L10;
        boolean r105 = true;
    L11:
        String r106 = null;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L33
        if (r105 == false) goto L15;
        FragmentType r108 = FragmentType.TYPE_CHAT_IMMERS;     // Catch: Throwable -> L33
    L16:
        Fragment r109 = b(r108);     // Catch: Throwable -> L33
        r109.setArguments(r101);     // Catch: Throwable -> L33
        if (r100 == null) goto L30;
        if (r105 == false) goto L20;
        this.f346032b.fa0(TabMode.NIGHT);     // Catch: Throwable -> L33
        r100.f294908e = true;     // Catch: Throwable -> L33
    L22:
        if (r100.U90() == null) goto L31;
        FragmentTransaction r110 = r100.getChildFragmentManager().beginTransaction();     // Catch: Throwable -> L33
        int r111 = BaseHomeTabFragment.f294907i;     // Catch: Throwable -> L33
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r110, r109, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "chat_fragment_tag", R.id.main_tab_chat_container) == true) goto L27;
        r110 = r110.replace(R.id.main_tab_chat_container, r109, "chat_fragment_tag");     // Catch: Throwable -> L33
    L27:
        r110.setCustomAnimations(R.anim.larus_fade_in, 0, 0, 0).commitAllowingStateLoss();     // Catch: Throwable -> L33
        View r112 = this.f346033c;     // Catch: Throwable -> L33
        if (r112 == null) goto L31;
        com.larus.utils.e1.x(r112);     // Catch: Throwable -> L33
    L31:
        Object r113 = Result.m9449constructorimpl(r100);     // Catch: Throwable -> L33
    L36:
        if (Result.m9455isFailureimpl(r113) == false) goto L44;
        int r114 = a0.f346060a;
        StringBuilder r115 = new StringBuilder("closeChatFragment error = ");
        Throwable r116 = Result.m9452exceptionOrNullimpl(r113);
        if (r116 == null) goto L40;
        r106 = com.larus.utils.u0.a(r116);
    L40:
        r115.append(r106);
        tx9.y.a(-1, r115.toString());
        FLogger.f375446a.e("ChatRouterTabInterceptor", "restartChatFragment fail");
        return;
    L44:
        return;
    L20:
        r100.f294908e = false;     // Catch: Throwable -> L33
        this.f346032b.fa0(TabMode.AUTO);     // Catch: Throwable -> L33
        goto L22
    L30:
        r100 = null;
        goto L31
    L15:
        r108 = FragmentType.TYPE_CHAT;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L10:
        r105 = false;
        goto L11
    }

    public static void a(final BottomPermanentFragmentFactory r100, final MainTabFragment r101, final BaseHomeTabFragment r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        final boolean r104 = true;
    L6:
        String r105 = null;
        if ((r103 & 4) == 0) goto L9;
        r102 = null;
    L9:
        Intrinsics.checkNotNullParameter(r101, "mainTabFg");
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L29
        if (r102 != null) goto L14;
        r102 = r100.d(null);     // Catch: Throwable -> L29
    L14:
        if ((r102 instanceof ka8.a) == false) goto L16;
    L21:
        r101.fa0(TabMode.NIGHT);     // Catch: Throwable -> L29
        r102.f294908e = true;     // Catch: Throwable -> L29
    L22:
        if (r102 == null) goto L26;
        View r107 = r102.getView();     // Catch: Throwable -> L29
        if (r107 == null) goto L26;
        Boolean r108 = Boolean.valueOf(r107.post(new n(r102, r100, r104, r101)));     // Catch: Throwable -> L29
    L27:
        Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L29
    L32:
        if (Result.m9455isFailureimpl(r109) == false) goto L40;
        int r110 = a0.f346060a;
        StringBuilder r111 = new StringBuilder("closeChatFragment error = ");
        Throwable r112 = Result.m9452exceptionOrNullimpl(r109);
        if (r112 == null) goto L36;
        r105 = com.larus.utils.u0.a(r112);
    L36:
        r111.append(r105);
        tx9.y.a(-1, r111.toString());
        FLogger.f375446a.e("ChatRouterTabInterceptor", "closeChatFragment fail");
        return;
    L40:
        return;
    L26:
        r108 = null;
        goto L27
    L16:
        if ((r102 instanceof ChatImmersFragment) == true) goto L21;
        if (r102 == null) goto L20;
        r102.f294908e = false;     // Catch: Throwable -> L29
    L20:
        r101.fa0(TabMode.AUTO);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L32
    L5:
        r104 = false;
        goto L6
    }
}
