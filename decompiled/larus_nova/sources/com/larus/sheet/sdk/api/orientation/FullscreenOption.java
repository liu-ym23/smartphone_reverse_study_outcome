package com.larus.sheet.sdk.api.orientation;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0017B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\rR \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/larus/sheet/sdk/api/orientation/FullscreenOption;", "", "hideStatusBar", "", "hideNavigationBar", "immersive", "clickFrom", "", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "getHideStatusBar", "()Ljava/lang/Boolean;", "setHideStatusBar", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getHideNavigationBar", "setHideNavigationBar", "getImmersive", "setImmersive", "getClickFrom", "()Ljava/lang/String;", "setClickFrom", "(Ljava/lang/String;)V", "Preset", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FullscreenOption {

    @SerializedName("clickFrom")
    private String clickFrom;

    @SerializedName("hideNavigationBar")
    private Boolean hideNavigationBar;

    @SerializedName("hideStatusBar")
    private Boolean hideStatusBar;

    @SerializedName("immersive")
    private Boolean immersive;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007j\u0002\b\u0004j\u0002\b\u0005¨\u0006\b"}, d2 = {"Lcom/larus/sheet/sdk/api/orientation/FullscreenOption$Preset;", "", "<init>", "(Ljava/lang/String;I)V", "ALL_TRUE", "ALL_FALSE", "toOption", "Lcom/larus/sheet/sdk/api/orientation/FullscreenOption;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Preset extends Enum<Preset> {
        public static final Preset ALL_FALSE = null;
        public static final Preset ALL_TRUE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Preset[] f369130a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f369131b = null;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f369132a = null;

            static {
                int[] r100 = new int[Preset.values().length];
                r100[Preset.ALL_TRUE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[Preset.ALL_FALSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f369132a = r100;
            }
        }

        public static EnumEntries<Preset> getEntries() {
            return f369131b;
        }

        static {
            Preset r100 = new Preset("ALL_TRUE", 0);
            ALL_TRUE = r100;
            Preset r101 = new Preset("ALL_FALSE", 1);
            ALL_FALSE = r101;
            Preset[] r102 = {r100, r101};
            f369130a = r102;
            f369131b = EnumEntriesKt.enumEntries(r102);
        }

        public static Preset[] values() {
            return (Preset[]) f369130a.clone();
        }

        public final FullscreenOption toOption() {
            int r100 = a.f369132a[ordinal()];
            if (r100 != 1) goto L5;
            Boolean r101 = Boolean.TRUE;
            return new FullscreenOption(r101, r101, r101, null, 8, null);
        L5:
            if (r100 != 2) goto L8;
            Boolean r102 = Boolean.FALSE;
            return new FullscreenOption(r102, r102, r102, null, 8, null);
        L8:
            throw new NoWhenBranchMatchedException();
        }

        public static Preset valueOf(String r100) {
            return (Preset) r27.a.a(Preset.class, r100);
        }

        public Preset(String r100, int r101) {
            super(r100, r101);
        }
    }

    public FullscreenOption() {
        this(null, null, null, null, 15, null);
    }

    public final String getClickFrom() {
        return this.clickFrom;
    }

    public final Boolean getHideNavigationBar() {
        return this.hideNavigationBar;
    }

    public final Boolean getHideStatusBar() {
        return this.hideStatusBar;
    }

    public final Boolean getImmersive() {
        return this.immersive;
    }

    public final void setClickFrom(String r100) {
        this.clickFrom = r100;
    }

    public final void setHideNavigationBar(Boolean r100) {
        this.hideNavigationBar = r100;
    }

    public final void setHideStatusBar(Boolean r100) {
        this.hideStatusBar = r100;
    }

    public final void setImmersive(Boolean r100) {
        this.immersive = r100;
    }

    public FullscreenOption(Boolean r100, Boolean r101, Boolean r102, String r103) {
        this.hideStatusBar = r100;
        this.hideNavigationBar = r101;
        this.immersive = r102;
        this.clickFrom = r103;
    }

    public /* synthetic */ FullscreenOption(Boolean r100, Boolean r101, Boolean r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = Boolean.TRUE;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = Boolean.TRUE;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = Boolean.TRUE;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
