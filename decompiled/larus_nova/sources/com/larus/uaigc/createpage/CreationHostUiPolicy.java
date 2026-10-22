package com.larus.uaigc.createpage;

import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class CreationHostUiPolicy {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f371382f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f371383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f371384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f371385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f371386d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f371387e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/uaigc/createpage/CreationHostUiPolicy$ExitAction;", "", "<init>", "(Ljava/lang/String;I)V", "FINISH_NATIVE", "NAVIGATE_BACK_IN_HOST", "CLOSE_HOST", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ExitAction extends Enum<ExitAction> {
        public static final ExitAction CLOSE_HOST = null;
        public static final ExitAction FINISH_NATIVE = null;
        public static final ExitAction NAVIGATE_BACK_IN_HOST = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ExitAction[] f371388a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f371389b = null;

        public static EnumEntries<ExitAction> getEntries() {
            return f371389b;
        }

        static {
            ExitAction r100 = new ExitAction("FINISH_NATIVE", 0);
            FINISH_NATIVE = r100;
            ExitAction r101 = new ExitAction("NAVIGATE_BACK_IN_HOST", 1);
            NAVIGATE_BACK_IN_HOST = r101;
            ExitAction r102 = new ExitAction("CLOSE_HOST", 2);
            CLOSE_HOST = r102;
            ExitAction[] r103 = {r100, r101, r102};
            f371388a = r103;
            f371389b = EnumEntriesKt.enumEntries(r103);
        }

        public static ExitAction[] values() {
            return (ExitAction[]) f371388a.clone();
        }

        public static ExitAction valueOf(String r100) {
            return (ExitAction) r27.a.a(ExitAction.class, r100);
        }

        public ExitAction(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/uaigc/createpage/CreationHostUiPolicy$KeyboardChromeMode;", "", "<init>", "(Ljava/lang/String;I)V", "NATIVE", "HOST_ROOT_SCRIM", "HOST_ROOT_CLEAR", "HOST_KEEP_CLEAR", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum KeyboardChromeMode extends Enum<KeyboardChromeMode> {
        public static final KeyboardChromeMode HOST_KEEP_CLEAR = null;
        public static final KeyboardChromeMode HOST_ROOT_CLEAR = null;
        public static final KeyboardChromeMode HOST_ROOT_SCRIM = null;
        public static final KeyboardChromeMode NATIVE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ KeyboardChromeMode[] f371390a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f371391b = null;

        public static EnumEntries<KeyboardChromeMode> getEntries() {
            return f371391b;
        }

        static {
            KeyboardChromeMode r100 = new KeyboardChromeMode("NATIVE", 0);
            NATIVE = r100;
            KeyboardChromeMode r101 = new KeyboardChromeMode("HOST_ROOT_SCRIM", 1);
            HOST_ROOT_SCRIM = r101;
            KeyboardChromeMode r102 = new KeyboardChromeMode("HOST_ROOT_CLEAR", 2);
            HOST_ROOT_CLEAR = r102;
            KeyboardChromeMode r103 = new KeyboardChromeMode("HOST_KEEP_CLEAR", 3);
            HOST_KEEP_CLEAR = r103;
            KeyboardChromeMode[] r104 = {r100, r101, r102, r103};
            f371390a = r104;
            f371391b = EnumEntriesKt.enumEntries(r104);
        }

        public static KeyboardChromeMode[] values() {
            return (KeyboardChromeMode[]) f371390a.clone();
        }

        public static KeyboardChromeMode valueOf(String r100) {
            return (KeyboardChromeMode) r27.a.a(KeyboardChromeMode.class, r100);
        }

        public KeyboardChromeMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/uaigc/createpage/CreationHostUiPolicy$LeadingAction;", "", "<init>", "(Ljava/lang/String;I)V", "CLOSE", "BACK", UserProfileEvent.POSITION_NONE, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LeadingAction extends Enum<LeadingAction> {
        public static final LeadingAction BACK = null;
        public static final LeadingAction CLOSE = null;
        public static final LeadingAction NONE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LeadingAction[] f371392a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f371393b = null;

        public static EnumEntries<LeadingAction> getEntries() {
            return f371393b;
        }

        static {
            LeadingAction r100 = new LeadingAction("CLOSE", 0);
            CLOSE = r100;
            LeadingAction r101 = new LeadingAction("BACK", 1);
            BACK = r101;
            LeadingAction r102 = new LeadingAction(UserProfileEvent.POSITION_NONE, 2);
            NONE = r102;
            LeadingAction[] r103 = {r100, r101, r102};
            f371392a = r103;
            f371393b = EnumEntriesKt.enumEntries(r103);
        }

        public static LeadingAction[] values() {
            return (LeadingAction[]) f371392a.clone();
        }

        public static LeadingAction valueOf(String r100) {
            return (LeadingAction) r27.a.a(LeadingAction.class, r100);
        }

        public LeadingAction(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/uaigc/createpage/CreationHostUiPolicy$TitleBarMode;", "", "<init>", "(Ljava/lang/String;I)V", "NATIVE", "HOST_HOME_ROOT", "HOST_ROOT", "HOST_SECONDARY", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TitleBarMode extends Enum<TitleBarMode> {
        public static final TitleBarMode HOST_HOME_ROOT = null;
        public static final TitleBarMode HOST_ROOT = null;
        public static final TitleBarMode HOST_SECONDARY = null;
        public static final TitleBarMode NATIVE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TitleBarMode[] f371394a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f371395b = null;

        public static EnumEntries<TitleBarMode> getEntries() {
            return f371395b;
        }

        static {
            TitleBarMode r100 = new TitleBarMode("NATIVE", 0);
            NATIVE = r100;
            TitleBarMode r101 = new TitleBarMode("HOST_HOME_ROOT", 1);
            HOST_HOME_ROOT = r101;
            TitleBarMode r102 = new TitleBarMode("HOST_ROOT", 2);
            HOST_ROOT = r102;
            TitleBarMode r103 = new TitleBarMode("HOST_SECONDARY", 3);
            HOST_SECONDARY = r103;
            TitleBarMode[] r104 = {r100, r101, r102, r103};
            f371394a = r104;
            f371395b = EnumEntriesKt.enumEntries(r104);
        }

        public static TitleBarMode[] values() {
            return (TitleBarMode[]) f371394a.clone();
        }

        public static TitleBarMode valueOf(String r100) {
            return (TitleBarMode) r27.a.a(TitleBarMode.class, r100);
        }

        public TitleBarMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public static CreationHostUiPolicy a(Bundle r100) {
            cy9.a r101 = cy9.a.f465949a;
            r101.getClass();
            boolean r102 = cy9.a.e(r100);
            String r103 = cy9.a.b(r100);
            boolean r104 = cy9.a.g(r100);
            Bundle r105 = r101.c(r100);
            if (r105 != null) goto L5;
            r105 = r100;
        L5:
            boolean r106 = cy9.a.i(r105, "route_result_to_chat_after_ai_creation_applet");
            Bundle r107 = r101.c(r100);
            if (r107 == null) goto L10;
            r100 = r107;
        L10:
            return new CreationHostUiPolicy(r102, r103, r104, r106, cy9.a.i(r100, "finish_native_host_below_ai_creation_applet_on_send"));
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TitleBarMode f371396a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LeadingAction f371397b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f371398c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f371399d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f371396a == r101.f371396a) goto L12;
            return false;
        L12:
            if (this.f371397b == r101.f371397b) goto L15;
            return false;
        L15:
            if (this.f371398c == r101.f371398c) goto L18;
            return false;
        L18:
            if (this.f371399d == r101.f371399d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f371396a.hashCode() * 31) + this.f371397b.hashCode()) * 31;
            int r101 = 1231;
            if (this.f371398c == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f371399d == true) goto L11;
            r101 = 1237;
        L11:
            return r103 + r101;
        L5:
            r102 = 1237;
            goto L6
        }

        public final String toString() {
            return "TitleBarSpec(mode=" + this.f371396a + ", leadingAction=" + this.f371397b + ", showAvatarEntrance=" + this.f371398c + ", useDefaultTitleWhenEmpty=" + this.f371399d + ')';
        }

        public b(TitleBarMode r100, LeadingAction r101, boolean r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r100, "mode");
            Intrinsics.checkNotNullParameter(r101, "leadingAction");
            this.f371396a = r100;
            this.f371397b = r101;
            this.f371398c = r102;
            this.f371399d = r103;
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f371400a = null;

        static {
            int[] r100 = new int[TitleBarMode.values().length];
            r100[TitleBarMode.HOST_HOME_ROOT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[TitleBarMode.HOST_ROOT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[TitleBarMode.HOST_SECONDARY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[TitleBarMode.NATIVE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f371400a = r100;
        }
    }

    static {
    }

    public final TitleBarMode c() {
        if (this.f371383a == true) goto L6;
        return TitleBarMode.NATIVE;
    L6:
        if (this.f371385c == false) goto L11;
        cy9.a r100 = cy9.a.f465949a;
        String r101 = this.f371384b;
        r100.getClass();
        if (cy9.a.f(r101) == false) goto L11;
        return TitleBarMode.HOST_HOME_ROOT;
    L11:
        if (this.f371385c == false) goto L14;
        return TitleBarMode.HOST_ROOT;
    L14:
        return TitleBarMode.HOST_SECONDARY;
    }

    public final ExitAction b() {
        TitleBarMode r100 = c();
        int r101 = c.f371400a[r100.ordinal()];
        if (r101 == 1) goto L15;
        if (r101 == 2) goto L15;
        if (r101 == 3) goto L17;
        if (r101 != 4) goto L12;
        return ExitAction.FINISH_NATIVE;
    L12:
        throw new NoWhenBranchMatchedException();
    L17:
        return ExitAction.NAVIGATE_BACK_IN_HOST;
    L15:
        return ExitAction.CLOSE_HOST;
    }

    public final void a(ConstraintLayout.LayoutParams r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        r100.topToBottom = -1;
        r100.topToTop = -1;
        if (this.f371383a == false) goto L5;
        r100.topToBottom = R.id.title;
        return;
    L5:
        if (r101 == null) goto L7;
        r100.topToBottom = r101.intValue();
        return;
    L7:
        r100.topToTop = 0;
    }

    public CreationHostUiPolicy(boolean r100, String r101, boolean r102, boolean r103, boolean r104) {
        this.f371383a = r100;
        this.f371384b = r101;
        this.f371385c = r102;
        this.f371386d = r103;
        this.f371387e = r104;
    }
}
