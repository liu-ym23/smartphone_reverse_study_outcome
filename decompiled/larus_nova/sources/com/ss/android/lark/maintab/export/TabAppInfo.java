package com.ss.android.lark.maintab.export;

import android.text.TextUtils;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.lark.pb.basic.v1.NavigationAppInfo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ss.ttm.player.MediaPlayer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0018\b\u0087\b\u0018\u0000 J2\u00020\u0001:\bCDEFGHIJB\u0099\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010/\u001a\u00020\u0000J\u0013\u00100\u001a\u00020\u000e2\b\u00101\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00102\u001a\u000203H\u0016J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0006HÆ\u0003J\t\u00107\u001a\u00020\bHÆ\u0003J\u0015\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003J\t\u00109\u001a\u00020\fHÆ\u0003J\t\u0010:\u001a\u00020\u000eHÆ\u0003J\t\u0010;\u001a\u00020\u000eHÆ\u0003J\t\u0010<\u001a\u00020\u0011HÆ\u0003J\t\u0010=\u001a\u00020\u000eHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\u009b\u0001\u0010A\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0003HÆ\u0001J\t\u0010B\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010%R\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010%R\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0011\u0010\u0012\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010%R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001b¨\u0006K"}, d2 = {"Lcom/ss/android/lark/maintab/export/TabAppInfo;", "", "key", "", "uniqueId", "tabAppType", "Lcom/ss/android/lark/maintab/export/TabAppType;", "logo", "Lcom/ss/android/lark/maintab/export/TabAppInfo$Logo;", "name", "", "extra", "Lcom/ss/android/lark/maintab/export/TabAppInfo$Extra;", "isPrimaryOnly", "", "isUnmovable", "tabSite", "Lcom/ss/android/lark/maintab/export/TabSite;", "isErasable", "openMode", "Lcom/ss/android/lark/maintab/export/TabAppInfo$NavigationOpenMode;", "source", "Lcom/ss/android/lark/maintab/export/TabAppInfo$NavigationSource;", "subTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/maintab/export/TabAppType;Lcom/ss/android/lark/maintab/export/TabAppInfo$Logo;Ljava/util/Map;Lcom/ss/android/lark/maintab/export/TabAppInfo$Extra;ZZLcom/ss/android/lark/maintab/export/TabSite;ZLcom/ss/android/lark/maintab/export/TabAppInfo$NavigationOpenMode;Lcom/ss/android/lark/maintab/export/TabAppInfo$NavigationSource;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getUniqueId", "getTabAppType", "()Lcom/ss/android/lark/maintab/export/TabAppType;", "getLogo", "()Lcom/ss/android/lark/maintab/export/TabAppInfo$Logo;", "getName", "()Ljava/util/Map;", "getExtra", "()Lcom/ss/android/lark/maintab/export/TabAppInfo$Extra;", "()Z", "getTabSite", "()Lcom/ss/android/lark/maintab/export/TabSite;", "setTabSite", "(Lcom/ss/android/lark/maintab/export/TabSite;)V", "getOpenMode", "()Lcom/ss/android/lark/maintab/export/TabAppInfo$NavigationOpenMode;", "getSource", "()Lcom/ss/android/lark/maintab/export/TabAppInfo$NavigationSource;", "getSubTitle", "deepCopy", "equals", "other", "hashCode", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "toString", "Logo", "CustomNavigationAppLogo", "CustomNavigationAppLogoType", "Extra", "BizType", "NavigationOpenMode", "NavigationSource", "Companion", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TabAppInfo {
    public static final a Companion = null;
    public static final String IMAGE_JSON_KEY = "key";
    public static final String TAG = "TabModule_TabAppInfo";
    private final Extra extra;
    private final boolean isErasable;
    private final boolean isPrimaryOnly;
    private final boolean isUnmovable;
    private final String key;
    private final Logo logo;
    private final Map<String, String> name;
    private final NavigationOpenMode openMode;
    private final NavigationSource source;
    private final String subTitle;
    private final TabAppType tabAppType;

    @Expose
    private TabSite tabSite;
    private final String uniqueId;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/maintab/export/TabAppInfo$BizType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_TYPE", "CCM", "MINI_APP", "WEB_APP", "MEEGO", "WEB", "Companion", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum BizType extends Enum<BizType> {
        public static final BizType CCM = null;
        public static final a Companion = null;
        public static final BizType MEEGO = null;
        public static final BizType MINI_APP = null;
        public static final BizType UNKNOWN_TYPE = null;
        public static final BizType WEB = null;
        public static final BizType WEB_APP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BizType[] f431589a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f431590b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<BizType> getEntries() {
            return f431590b;
        }

        static {
            BizType r100 = new BizType("UNKNOWN_TYPE", 0, 0);
            UNKNOWN_TYPE = r100;
            BizType r101 = new BizType("CCM", 1, 1);
            CCM = r101;
            BizType r102 = new BizType("MINI_APP", 2, 2);
            MINI_APP = r102;
            BizType r103 = new BizType("WEB_APP", 3, 3);
            WEB_APP = r103;
            BizType r104 = new BizType("MEEGO", 4, 4);
            MEEGO = r104;
            BizType r105 = new BizType("WEB", 5, 5);
            WEB = r105;
            BizType[] r110 = {r100, r101, r102, r103, r104, r105};
            f431589a = r110;
            f431590b = EnumEntriesKt.enumEntries(r110);
            Companion = new a();
        }

        public static BizType[] values() {
            return (BizType[]) f431589a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static BizType valueOf(String r100) {
            return (BizType) r27.a.a(BizType.class, r100);
        }

        public BizType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/maintab/export/TabAppInfo$CustomNavigationAppLogoType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "APP_LOGO_TYPE_UNKNOWN", "APP_LOGO_TYPE_UD_TOKEN", "APP_LOGO_TYPE_URL", "APP_LOGO_TYPE_IMAGE_KEY", "APP_LOGO_TYPE_CCM_ICON", "Companion", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CustomNavigationAppLogoType extends Enum<CustomNavigationAppLogoType> {
        public static final CustomNavigationAppLogoType APP_LOGO_TYPE_CCM_ICON = null;
        public static final CustomNavigationAppLogoType APP_LOGO_TYPE_IMAGE_KEY = null;
        public static final CustomNavigationAppLogoType APP_LOGO_TYPE_UD_TOKEN = null;
        public static final CustomNavigationAppLogoType APP_LOGO_TYPE_UNKNOWN = null;
        public static final CustomNavigationAppLogoType APP_LOGO_TYPE_URL = null;
        public static final a Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CustomNavigationAppLogoType[] f431591a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f431592b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<CustomNavigationAppLogoType> getEntries() {
            return f431592b;
        }

        static {
            CustomNavigationAppLogoType r100 = new CustomNavigationAppLogoType("APP_LOGO_TYPE_UNKNOWN", 0, 0);
            APP_LOGO_TYPE_UNKNOWN = r100;
            CustomNavigationAppLogoType r101 = new CustomNavigationAppLogoType("APP_LOGO_TYPE_UD_TOKEN", 1, 1);
            APP_LOGO_TYPE_UD_TOKEN = r101;
            CustomNavigationAppLogoType r102 = new CustomNavigationAppLogoType("APP_LOGO_TYPE_URL", 2, 2);
            APP_LOGO_TYPE_URL = r102;
            CustomNavigationAppLogoType r103 = new CustomNavigationAppLogoType("APP_LOGO_TYPE_IMAGE_KEY", 3, 3);
            APP_LOGO_TYPE_IMAGE_KEY = r103;
            CustomNavigationAppLogoType r104 = new CustomNavigationAppLogoType("APP_LOGO_TYPE_CCM_ICON", 4, 4);
            APP_LOGO_TYPE_CCM_ICON = r104;
            CustomNavigationAppLogoType[] r105 = {r100, r101, r102, r103, r104};
            f431591a = r105;
            f431592b = EnumEntriesKt.enumEntries(r105);
            Companion = new a();
        }

        public static CustomNavigationAppLogoType[] values() {
            return (CustomNavigationAppLogoType[]) f431591a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static CustomNavigationAppLogoType valueOf(String r100) {
            return (CustomNavigationAppLogoType) r27.a.a(CustomNavigationAppLogoType.class, r100);
        }

        public CustomNavigationAppLogoType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u001a\u001a\u00020\u0000J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003Jc\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006+"}, d2 = {"Lcom/ss/android/lark/maintab/export/TabAppInfo$Extra;", "", com.heytap.mcssdk.constant.b.f276371u, "", "url", "bizType", "Lcom/ss/android/lark/maintab/export/TabAppInfo$BizType;", "bizId", "uniqueId", "docSubType", "hardwareBinding", "webUseFullURLMatch", "useCustomNaviAppbarAppearance", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/maintab/export/TabAppInfo$BizType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppID", "()Ljava/lang/String;", "getUrl", "getBizType", "()Lcom/ss/android/lark/maintab/export/TabAppInfo$BizType;", "getBizId", "getUniqueId", "getDocSubType", "getHardwareBinding", "getWebUseFullURLMatch", "getUseCustomNaviAppbarAppearance", "deepCopy", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Extra {

        @SerializedName("app_id")
        private final String appID;

        @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID)
        private final String bizId;

        @SerializedName("biz_type")
        private final BizType bizType;

        @SerializedName("doc_sub_type")
        private final String docSubType;

        @SerializedName("hardware_binding")
        private final String hardwareBinding;

        @SerializedName(BdpAppEventConstant.PARAMS_UNIQUEID)
        private final String uniqueId;

        @SerializedName("mobile_url")
        private final String url;

        @SerializedName("use_custom_navi_appbar_appearance")
        private final String useCustomNaviAppbarAppearance;

        @SerializedName("webUseFullURLMatch")
        private final String webUseFullURLMatch;

        public Extra() {
            this(null, null, null, null, null, null, null, null, null, 511, null);
        }

        public static /* synthetic */ Extra copy$default(Extra r110, String r111, String r112, BizType r113, String r114, String r115, String r116, String r117, String r118, String r119, int r210, Object r211) {
            if ((r210 & 1) == 0) goto L5;
            String r100 = r110.appID;
        L7:
            if ((r210 & 2) == 0) goto L9;
            String r101 = r110.url;
        L11:
            if ((r210 & 4) == 0) goto L13;
            BizType r102 = r110.bizType;
        L15:
            if ((r210 & 8) == 0) goto L17;
            String r103 = r110.bizId;
        L19:
            if ((r210 & 16) == 0) goto L21;
            String r104 = r110.uniqueId;
        L23:
            if ((r210 & 32) == 0) goto L25;
            String r105 = r110.docSubType;
        L27:
            if ((r210 & 64) == 0) goto L29;
            String r106 = r110.hardwareBinding;
        L31:
            if ((r210 & 128) == 0) goto L33;
            String r107 = r110.webUseFullURLMatch;
        L35:
            if ((r210 & 256) == 0) goto L37;
            String r108 = r110.useCustomNaviAppbarAppearance;
        L39:
            return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
        L37:
            r108 = r119;
            goto L39
        L33:
            r107 = r118;
            goto L35
        L29:
            r106 = r117;
            goto L31
        L25:
            r105 = r116;
            goto L27
        L21:
            r104 = r115;
            goto L23
        L17:
            r103 = r114;
            goto L19
        L13:
            r102 = r113;
            goto L15
        L9:
            r101 = r112;
            goto L11
        L5:
            r100 = r111;
            goto L7
        }

        public final String component1() {
            return this.appID;
        }

        public final String component2() {
            return this.url;
        }

        public final BizType component3() {
            return this.bizType;
        }

        public final String component4() {
            return this.bizId;
        }

        public final String component5() {
            return this.uniqueId;
        }

        public final String component6() {
            return this.docSubType;
        }

        public final String component7() {
            return this.hardwareBinding;
        }

        public final String component8() {
            return this.webUseFullURLMatch;
        }

        public final String component9() {
            return this.useCustomNaviAppbarAppearance;
        }

        public final Extra copy(String r110, String r111, BizType r112, String r113, String r114, String r115, String r116, String r117, String r210) {
            Intrinsics.checkNotNullParameter(r110, com.heytap.mcssdk.constant.b.f276371u);
            Intrinsics.checkNotNullParameter(r111, "url");
            Intrinsics.checkNotNullParameter(r112, "bizType");
            Intrinsics.checkNotNullParameter(r113, "bizId");
            Intrinsics.checkNotNullParameter(r114, "uniqueId");
            Intrinsics.checkNotNullParameter(r115, "docSubType");
            Intrinsics.checkNotNullParameter(r116, "hardwareBinding");
            Intrinsics.checkNotNullParameter(r117, "webUseFullURLMatch");
            Intrinsics.checkNotNullParameter(r210, "useCustomNaviAppbarAppearance");
            return new Extra(r110, r111, r112, r113, r114, r115, r116, r117, r210);
        }

        public final Extra deepCopy() {
            return copy$default(this, null, null, null, null, null, null, null, null, null, 511, null);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Extra) == true) goto L8;
            return false;
        L8:
            Extra r101 = (Extra) r100;
            if (Intrinsics.areEqual(this.appID, r101.appID) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.url, r101.url) == true) goto L15;
            return false;
        L15:
            if (this.bizType == r101.bizType) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.bizId, r101.bizId) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.uniqueId, r101.uniqueId) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.docSubType, r101.docSubType) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.hardwareBinding, r101.hardwareBinding) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.webUseFullURLMatch, r101.webUseFullURLMatch) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.useCustomNaviAppbarAppearance, r101.useCustomNaviAppbarAppearance) == true) goto L35;
            return false;
        L35:
            return true;
        }

        public int hashCode() {
            return (((((((((((((((this.appID.hashCode() * 31) + this.url.hashCode()) * 31) + this.bizType.hashCode()) * 31) + this.bizId.hashCode()) * 31) + this.uniqueId.hashCode()) * 31) + this.docSubType.hashCode()) * 31) + this.hardwareBinding.hashCode()) * 31) + this.webUseFullURLMatch.hashCode()) * 31) + this.useCustomNaviAppbarAppearance.hashCode();
        }

        public String toString() {
            return "Extra(appID=" + this.appID + ", url=" + this.url + ", bizType=" + this.bizType + ", bizId=" + this.bizId + ", uniqueId=" + this.uniqueId + ", docSubType=" + this.docSubType + ", hardwareBinding=" + this.hardwareBinding + ", webUseFullURLMatch=" + this.webUseFullURLMatch + ", useCustomNaviAppbarAppearance=" + this.useCustomNaviAppbarAppearance + ')';
        }

        public final String getAppID() {
            return this.appID;
        }

        public final String getBizId() {
            return this.bizId;
        }

        public final BizType getBizType() {
            return this.bizType;
        }

        public final String getDocSubType() {
            return this.docSubType;
        }

        public final String getHardwareBinding() {
            return this.hardwareBinding;
        }

        public final String getUniqueId() {
            return this.uniqueId;
        }

        public final String getUrl() {
            return this.url;
        }

        public final String getUseCustomNaviAppbarAppearance() {
            return this.useCustomNaviAppbarAppearance;
        }

        public final String getWebUseFullURLMatch() {
            return this.webUseFullURLMatch;
        }

        public Extra(String r100, String r101, BizType r102, String r103, String r104, String r105, String r106, String r107, String r110) {
            Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276371u);
            Intrinsics.checkNotNullParameter(r101, "url");
            Intrinsics.checkNotNullParameter(r102, "bizType");
            Intrinsics.checkNotNullParameter(r103, "bizId");
            Intrinsics.checkNotNullParameter(r104, "uniqueId");
            Intrinsics.checkNotNullParameter(r105, "docSubType");
            Intrinsics.checkNotNullParameter(r106, "hardwareBinding");
            Intrinsics.checkNotNullParameter(r107, "webUseFullURLMatch");
            Intrinsics.checkNotNullParameter(r110, "useCustomNaviAppbarAppearance");
            this.appID = r100;
            this.url = r101;
            this.bizType = r102;
            this.bizId = r103;
            this.uniqueId = r104;
            this.docSubType = r105;
            this.hardwareBinding = r106;
            this.webUseFullURLMatch = r107;
            this.useCustomNaviAppbarAppearance = r110;
        }

        public /* synthetic */ Extra(String r110, String r111, BizType r112, String r113, String r114, String r115, String r116, String r117, String r118, int r210, DefaultConstructorMarker r211) {
            String r100 = "";
            if ((r210 & 1) == 0) goto L5;
            String r101 = "";
        L7:
            if ((r210 & 2) == 0) goto L9;
            String r102 = "";
        L11:
            if ((r210 & 4) == 0) goto L13;
            BizType r103 = BizType.UNKNOWN_TYPE;
        L15:
            if ((r210 & 8) == 0) goto L17;
            String r104 = "";
        L19:
            if ((r210 & 16) == 0) goto L21;
            String r105 = "";
        L23:
            if ((r210 & 32) == 0) goto L25;
            String r106 = "";
        L27:
            if ((r210 & 64) == 0) goto L29;
            String r107 = "0";
        L31:
            if ((r210 & 128) == 0) goto L33;
            String r108 = "";
        L35:
            if ((r210 & 256) != 0) goto L38;
            r100 = r118;
        L38:
            this(r101, r102, r103, r104, r105, r106, r107, r108, r100);
            return;
        L33:
            r108 = r117;
            goto L35
        L29:
            r107 = r116;
            goto L31
        L25:
            r106 = r115;
            goto L27
        L21:
            r105 = r114;
            goto L23
        L17:
            r104 = r113;
            goto L19
        L13:
            r103 = r112;
            goto L15
        L9:
            r102 = r111;
            goto L11
        L5:
            r101 = r110;
            goto L7
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u001e\u001a\u00020\u0000J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\rHÆ\u0003Jg\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0011¨\u0006/"}, d2 = {"Lcom/ss/android/lark/maintab/export/TabAppInfo$Logo;", "", "primaryDefault", "", "primarySelected", "shortcutDefault", "primaryDefaultSvg", "primaryColorPng", "mobilePrimaryDefaultPng", "mobilePrimarySelectedPng", "customNavigationAppLogo", "Lcom/ss/android/lark/maintab/export/TabAppInfo$CustomNavigationAppLogo;", "logoStyle", "Lcom/bytedance/lark/pb/basic/v1/NavigationAppInfo$Logo$LogoStyle;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/maintab/export/TabAppInfo$CustomNavigationAppLogo;Lcom/bytedance/lark/pb/basic/v1/NavigationAppInfo$Logo$LogoStyle;)V", "getPrimaryDefault", "()Ljava/lang/String;", "getPrimarySelected", "getShortcutDefault", "getPrimaryDefaultSvg", "getPrimaryColorPng", "getMobilePrimaryDefaultPng", "getMobilePrimarySelectedPng", "getCustomNavigationAppLogo", "()Lcom/ss/android/lark/maintab/export/TabAppInfo$CustomNavigationAppLogo;", "getLogoStyle", "()Lcom/bytedance/lark/pb/basic/v1/NavigationAppInfo$Logo$LogoStyle;", "remotePng", "getRemotePng", "deepCopy", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Logo {

        @SerializedName("custom_navigation_app_logo")
        private final b customNavigationAppLogo;

        @SerializedName("logo_style")
        private final NavigationAppInfo.Logo.LogoStyle logoStyle;

        @SerializedName("mobile_primary_default_png")
        private final String mobilePrimaryDefaultPng;

        @SerializedName("mobile_primary_selected_png")
        private final String mobilePrimarySelectedPng;

        @SerializedName("primary_color_png")
        private final String primaryColorPng;

        @SerializedName("primary_default")
        private final String primaryDefault;

        @SerializedName("primary_default_svg")
        private final String primaryDefaultSvg;

        @SerializedName("primary_selected")
        private final String primarySelected;

        @SerializedName("shortcut_default")
        private final String shortcutDefault;

        public Logo() {
            this(null, null, null, null, null, null, null, null, null, 511, null);
        }

        public static /* synthetic */ Logo copy$default(Logo r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, b r118, NavigationAppInfo.Logo.LogoStyle r119, int r210, Object r211) {
            if ((r210 & 1) == 0) goto L5;
            String r100 = r110.primaryDefault;
        L7:
            if ((r210 & 2) == 0) goto L9;
            String r101 = r110.primarySelected;
        L11:
            if ((r210 & 4) == 0) goto L13;
            String r102 = r110.shortcutDefault;
        L15:
            if ((r210 & 8) == 0) goto L17;
            String r103 = r110.primaryDefaultSvg;
        L19:
            if ((r210 & 16) == 0) goto L21;
            String r104 = r110.primaryColorPng;
        L23:
            if ((r210 & 32) == 0) goto L25;
            String r105 = r110.mobilePrimaryDefaultPng;
        L27:
            if ((r210 & 64) == 0) goto L29;
            String r106 = r110.mobilePrimarySelectedPng;
        L31:
            if ((r210 & 128) == 0) goto L33;
            b r107 = r110.customNavigationAppLogo;
        L35:
            if ((r210 & 256) == 0) goto L37;
            NavigationAppInfo.Logo.LogoStyle r108 = r110.logoStyle;
        L39:
            return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
        L37:
            r108 = r119;
            goto L39
        L33:
            r107 = r118;
            goto L35
        L29:
            r106 = r117;
            goto L31
        L25:
            r105 = r116;
            goto L27
        L21:
            r104 = r115;
            goto L23
        L17:
            r103 = r114;
            goto L19
        L13:
            r102 = r113;
            goto L15
        L9:
            r101 = r112;
            goto L11
        L5:
            r100 = r111;
            goto L7
        }

        public final String component1() {
            return this.primaryDefault;
        }

        public final String component2() {
            return this.primarySelected;
        }

        public final String component3() {
            return this.shortcutDefault;
        }

        public final String component4() {
            return this.primaryDefaultSvg;
        }

        public final String component5() {
            return this.primaryColorPng;
        }

        public final String component6() {
            return this.mobilePrimaryDefaultPng;
        }

        public final String component7() {
            return this.mobilePrimarySelectedPng;
        }

        public final b component8() {
            return this.customNavigationAppLogo;
        }

        public final NavigationAppInfo.Logo.LogoStyle component9() {
            return this.logoStyle;
        }

        public final Logo copy(String r110, String r111, String r112, String r113, String r114, String r115, String r116, b r117, NavigationAppInfo.Logo.LogoStyle r210) {
            Intrinsics.checkNotNullParameter(r110, "primaryDefault");
            Intrinsics.checkNotNullParameter(r111, "primarySelected");
            Intrinsics.checkNotNullParameter(r112, "shortcutDefault");
            Intrinsics.checkNotNullParameter(r113, "primaryDefaultSvg");
            Intrinsics.checkNotNullParameter(r114, "primaryColorPng");
            Intrinsics.checkNotNullParameter(r115, "mobilePrimaryDefaultPng");
            Intrinsics.checkNotNullParameter(r116, "mobilePrimarySelectedPng");
            return new Logo(r110, r111, r112, r113, r114, r115, r116, r117, r210);
        }

        public final Logo deepCopy() {
            b r100 = this.customNavigationAppLogo;
            if (r100 == null) goto L5;
            b r101 = r100.a();
        L7:
            return copy$default(this, null, null, null, null, null, null, null, r101, null, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_400, null);
        L5:
            r101 = null;
            goto L7
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Logo) == true) goto L8;
            return false;
        L8:
            Logo r101 = (Logo) r100;
            if (Intrinsics.areEqual(this.primaryDefault, r101.primaryDefault) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.primarySelected, r101.primarySelected) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.shortcutDefault, r101.shortcutDefault) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.primaryDefaultSvg, r101.primaryDefaultSvg) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.primaryColorPng, r101.primaryColorPng) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.mobilePrimaryDefaultPng, r101.mobilePrimaryDefaultPng) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.mobilePrimarySelectedPng, r101.mobilePrimarySelectedPng) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.customNavigationAppLogo, r101.customNavigationAppLogo) == true) goto L33;
            return false;
        L33:
            if (this.logoStyle == r101.logoStyle) goto L35;
            return false;
        L35:
            return true;
        }

        public int hashCode() {
            int r100 = ((((((((((((this.primaryDefault.hashCode() * 31) + this.primarySelected.hashCode()) * 31) + this.shortcutDefault.hashCode()) * 31) + this.primaryDefaultSvg.hashCode()) * 31) + this.primaryColorPng.hashCode()) * 31) + this.mobilePrimaryDefaultPng.hashCode()) * 31) + this.mobilePrimarySelectedPng.hashCode()) * 31;
            b r101 = this.customNavigationAppLogo;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            NavigationAppInfo.Logo.LogoStyle r105 = this.logoStyle;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return r104 + r102;
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public String toString() {
            return "Logo(primaryDefault=" + this.primaryDefault + ", primarySelected=" + this.primarySelected + ", shortcutDefault=" + this.shortcutDefault + ", primaryDefaultSvg=" + this.primaryDefaultSvg + ", primaryColorPng=" + this.primaryColorPng + ", mobilePrimaryDefaultPng=" + this.mobilePrimaryDefaultPng + ", mobilePrimarySelectedPng=" + this.mobilePrimarySelectedPng + ", customNavigationAppLogo=" + this.customNavigationAppLogo + ", logoStyle=" + this.logoStyle + ')';
        }

        public final String getRemotePng() {
            if (TextUtils.isEmpty(this.mobilePrimarySelectedPng) == true) goto L7;
            return this.mobilePrimarySelectedPng;
        L7:
            if (TextUtils.isEmpty(this.primaryColorPng) == true) goto L11;
            return this.primaryColorPng;
        L11:
            if (TextUtils.isEmpty(this.primarySelected) == true) goto L15;
            return this.primarySelected;
        L15:
            if (TextUtils.isEmpty(this.shortcutDefault) == false) goto L17;
            return "";
        L17:
            return this.shortcutDefault;
        }

        public final b getCustomNavigationAppLogo() {
            return this.customNavigationAppLogo;
        }

        public final NavigationAppInfo.Logo.LogoStyle getLogoStyle() {
            return this.logoStyle;
        }

        public final String getMobilePrimaryDefaultPng() {
            return this.mobilePrimaryDefaultPng;
        }

        public final String getMobilePrimarySelectedPng() {
            return this.mobilePrimarySelectedPng;
        }

        public final String getPrimaryColorPng() {
            return this.primaryColorPng;
        }

        public final String getPrimaryDefault() {
            return this.primaryDefault;
        }

        public final String getPrimaryDefaultSvg() {
            return this.primaryDefaultSvg;
        }

        public final String getPrimarySelected() {
            return this.primarySelected;
        }

        public final String getShortcutDefault() {
            return this.shortcutDefault;
        }

        public Logo(String r100, String r101, String r102, String r103, String r104, String r105, String r106, b r107, NavigationAppInfo.Logo.LogoStyle r110) {
            Intrinsics.checkNotNullParameter(r100, "primaryDefault");
            Intrinsics.checkNotNullParameter(r101, "primarySelected");
            Intrinsics.checkNotNullParameter(r102, "shortcutDefault");
            Intrinsics.checkNotNullParameter(r103, "primaryDefaultSvg");
            Intrinsics.checkNotNullParameter(r104, "primaryColorPng");
            Intrinsics.checkNotNullParameter(r105, "mobilePrimaryDefaultPng");
            Intrinsics.checkNotNullParameter(r106, "mobilePrimarySelectedPng");
            this.primaryDefault = r100;
            this.primarySelected = r101;
            this.shortcutDefault = r102;
            this.primaryDefaultSvg = r103;
            this.primaryColorPng = r104;
            this.mobilePrimaryDefaultPng = r105;
            this.mobilePrimarySelectedPng = r106;
            this.customNavigationAppLogo = r107;
            this.logoStyle = r110;
        }

        public /* synthetic */ Logo(String r110, String r111, String r112, String r113, String r114, String r115, String r116, b r117, NavigationAppInfo.Logo.LogoStyle r118, int r210, DefaultConstructorMarker r211) {
            String r100 = "";
            if ((r210 & 1) == 0) goto L5;
            String r101 = "";
        L7:
            if ((r210 & 2) == 0) goto L9;
            String r102 = "";
        L11:
            if ((r210 & 4) == 0) goto L13;
            String r103 = "";
        L15:
            if ((r210 & 8) == 0) goto L17;
            String r104 = "";
        L19:
            if ((r210 & 16) == 0) goto L21;
            String r105 = "";
        L23:
            if ((r210 & 32) == 0) goto L25;
            String r106 = "";
        L27:
            if ((r210 & 64) != 0) goto L30;
            r100 = r116;
        L30:
            NavigationAppInfo.Logo.LogoStyle r107 = null;
            if ((r210 & 128) == 0) goto L33;
            b r108 = null;
        L35:
            if ((r210 & 256) != 0) goto L38;
            r107 = r118;
        L38:
            this(r101, r102, r103, r104, r105, r106, r100, r108, r107);
            return;
        L33:
            r108 = r117;
            goto L35
        L25:
            r106 = r115;
            goto L27
        L21:
            r105 = r114;
            goto L23
        L17:
            r104 = r113;
            goto L19
        L13:
            r103 = r112;
            goto L15
        L9:
            r102 = r111;
            goto L11
        L5:
            r101 = r110;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/maintab/export/TabAppInfo$NavigationOpenMode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_MODE", "SWITCH_MODE", "PUSH_MODE", "RUNTIME_MODE", "Companion", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum NavigationOpenMode extends Enum<NavigationOpenMode> {
        public static final a Companion = null;
        public static final NavigationOpenMode PUSH_MODE = null;
        public static final NavigationOpenMode RUNTIME_MODE = null;
        public static final NavigationOpenMode SWITCH_MODE = null;
        public static final NavigationOpenMode UNKNOWN_MODE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ NavigationOpenMode[] f431593a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f431594b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<NavigationOpenMode> getEntries() {
            return f431594b;
        }

        static {
            NavigationOpenMode r100 = new NavigationOpenMode("UNKNOWN_MODE", 0, 0);
            UNKNOWN_MODE = r100;
            NavigationOpenMode r101 = new NavigationOpenMode("SWITCH_MODE", 1, 1);
            SWITCH_MODE = r101;
            NavigationOpenMode r102 = new NavigationOpenMode("PUSH_MODE", 2, 2);
            PUSH_MODE = r102;
            NavigationOpenMode r103 = new NavigationOpenMode("RUNTIME_MODE", 3, 100);
            RUNTIME_MODE = r103;
            NavigationOpenMode[] r104 = {r100, r101, r102, r103};
            f431593a = r104;
            f431594b = EnumEntriesKt.enumEntries(r104);
            Companion = new a();
        }

        public static NavigationOpenMode[] values() {
            return (NavigationOpenMode[]) f431593a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static NavigationOpenMode valueOf(String r100) {
            return (NavigationOpenMode) r27.a.a(NavigationOpenMode.class, r100);
        }

        public NavigationOpenMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/maintab/export/TabAppInfo$NavigationSource;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SOURCE_UNKNOWN", "TENANT_SOURCE", "USER_SOURCE", "Companion", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum NavigationSource extends Enum<NavigationSource> {
        public static final a Companion = null;
        public static final NavigationSource SOURCE_UNKNOWN = null;
        public static final NavigationSource TENANT_SOURCE = null;
        public static final NavigationSource USER_SOURCE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ NavigationSource[] f431595a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f431596b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<NavigationSource> getEntries() {
            return f431596b;
        }

        static {
            NavigationSource r100 = new NavigationSource("SOURCE_UNKNOWN", 0, 0);
            SOURCE_UNKNOWN = r100;
            NavigationSource r101 = new NavigationSource("TENANT_SOURCE", 1, 1);
            TENANT_SOURCE = r101;
            NavigationSource r102 = new NavigationSource("USER_SOURCE", 2, 2);
            USER_SOURCE = r102;
            NavigationSource[] r103 = {r100, r101, r102};
            f431595a = r103;
            f431596b = EnumEntriesKt.enumEntries(r103);
            Companion = new a();
        }

        public static NavigationSource[] values() {
            return (NavigationSource[]) f431595a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static NavigationSource valueOf(String r100) {
            return (NavigationSource) r27.a.a(NavigationSource.class, r100);
        }

        public NavigationSource(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\u0000J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/maintab/export/TabAppInfo$CustomNavigationAppLogo;", "", "content", "", "type", "Lcom/ss/android/lark/maintab/export/TabAppInfo$CustomNavigationAppLogoType;", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/maintab/export/TabAppInfo$CustomNavigationAppLogoType;)V", "getContent", "()Ljava/lang/String;", "getType", "()Lcom/ss/android/lark/maintab/export/TabAppInfo$CustomNavigationAppLogoType;", "deepCopy", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("content")
        private final String content;

        @SerializedName("type")
        private final CustomNavigationAppLogoType type;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.content, r101.content) == true) goto L12;
            return false;
        L12:
            if (this.type == r101.type) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.content.hashCode() * 31;
            CustomNavigationAppLogoType r101 = this.type;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "CustomNavigationAppLogo(content=" + this.content + ", type=" + this.type + ')';
        }

        public b() {
            this("", CustomNavigationAppLogoType.APP_LOGO_TYPE_UNKNOWN);
        }

        public final b a() {
            String r100 = this.content;
            CustomNavigationAppLogoType r101 = this.type;
            Intrinsics.checkNotNullParameter(r100, "content");
            return new b(r100, r101);
        }

        public final CustomNavigationAppLogoType getType() {
            return this.type;
        }

        public b(String r100, CustomNavigationAppLogoType r101) {
            Intrinsics.checkNotNullParameter(r100, "content");
            this.content = r100;
            this.type = r101;
        }
    }

    static {
        Companion = new a();
    }

    public TabAppInfo() {
        this(null, null, null, null, null, null, false, false, null, false, null, null, null, 8191, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TabAppInfo copy$default(TabAppInfo r110, String r111, String r112, TabAppType r113, Logo r114, Map r115, Extra r210, boolean r211, boolean r212, TabSite r213, boolean r214, NavigationOpenMode r215, NavigationSource r216, String r217, int r218, Object r219) {
        if ((r218 & 1) == 0) goto L5;
        String r100 = r110.key;
    L7:
        if ((r218 & 2) == 0) goto L9;
        String r101 = r110.uniqueId;
    L11:
        if ((r218 & 4) == 0) goto L13;
        TabAppType r102 = r110.tabAppType;
    L15:
        if ((r218 & 8) == 0) goto L17;
        Logo r103 = r110.logo;
    L19:
        if ((r218 & 16) == 0) goto L21;
        Map r104 = r110.name;
    L23:
        if ((r218 & 32) == 0) goto L25;
        Extra r105 = r110.extra;
    L27:
        if ((r218 & 64) == 0) goto L29;
        boolean r106 = r110.isPrimaryOnly;
    L31:
        if ((r218 & 128) == 0) goto L33;
        boolean r107 = r110.isUnmovable;
    L35:
        if ((r218 & 256) == 0) goto L37;
        TabSite r116 = r110.tabSite;
    L39:
        if ((r218 & 512) == 0) goto L41;
        boolean r117 = r110.isErasable;
    L43:
        if ((r218 & 1024) == 0) goto L45;
        NavigationOpenMode r118 = r110.openMode;
    L47:
        if ((r218 & 2048) == 0) goto L49;
        NavigationSource r119 = r110.source;
    L51:
        if ((r218 & 4096) == 0) goto L53;
        String r108 = r110.subTitle;
    L55:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r116, r117, r118, r119, r108);
    L53:
        r108 = r217;
        goto L55
    L49:
        r119 = r216;
        goto L51
    L45:
        r118 = r215;
        goto L47
    L41:
        r117 = r214;
        goto L43
    L37:
        r116 = r213;
        goto L39
    L33:
        r107 = r212;
        goto L35
    L29:
        r106 = r211;
        goto L31
    L25:
        r105 = r210;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.key;
    }

    public final boolean component10() {
        return this.isErasable;
    }

    public final NavigationOpenMode component11() {
        return this.openMode;
    }

    public final NavigationSource component12() {
        return this.source;
    }

    public final String component13() {
        return this.subTitle;
    }

    public final String component2() {
        return this.uniqueId;
    }

    public final TabAppType component3() {
        return this.tabAppType;
    }

    public final Logo component4() {
        return this.logo;
    }

    public final Map<String, String> component5() {
        return this.name;
    }

    public final Extra component6() {
        return this.extra;
    }

    public final boolean component7() {
        return this.isPrimaryOnly;
    }

    public final boolean component8() {
        return this.isUnmovable;
    }

    public final TabSite component9() {
        return this.tabSite;
    }

    public final TabAppInfo copy(String r110, String r111, TabAppType r112, Logo r113, Map<String, String> r210, Extra r211, boolean r212, boolean r213, TabSite r214, boolean r215, NavigationOpenMode r216, NavigationSource r217, String r218) {
        Intrinsics.checkNotNullParameter(r110, "key");
        Intrinsics.checkNotNullParameter(r111, "uniqueId");
        Intrinsics.checkNotNullParameter(r112, "tabAppType");
        Intrinsics.checkNotNullParameter(r113, "logo");
        Intrinsics.checkNotNullParameter(r210, "name");
        Intrinsics.checkNotNullParameter(r211, "extra");
        Intrinsics.checkNotNullParameter(r214, "tabSite");
        Intrinsics.checkNotNullParameter(r218, "subTitle");
        return new TabAppInfo(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.key, this.tabAppType});
    }

    public String toString() {
        return "TabAppInfo(key=" + this.key + ", uniqueId=" + this.uniqueId + ", tabAppType=" + this.tabAppType + ", logo=" + this.logo + ", name=" + this.name + ", extra=" + this.extra + ", isPrimaryOnly=" + this.isPrimaryOnly + ", isUnmovable=" + this.isUnmovable + ", tabSite=" + this.tabSite + ", isErasable=" + this.isErasable + ", openMode=" + this.openMode + ", source=" + this.source + ", subTitle=" + this.subTitle + ')';
    }

    public final TabAppInfo deepCopy() {
        Logo r100 = this.logo.deepCopy();
        LinkedHashMap r101 = new LinkedHashMap();
        r101.putAll(this.name);
        Unit r102 = Unit.INSTANCE;
        return copy$default(this, null, null, null, r100, r101, this.extra.deepCopy(), false, false, null, false, null, null, null, 8135, null);
    }

    public final Extra getExtra() {
        return this.extra;
    }

    public final String getKey() {
        return this.key;
    }

    public final Logo getLogo() {
        return this.logo;
    }

    public final Map<String, String> getName() {
        return this.name;
    }

    public final NavigationOpenMode getOpenMode() {
        return this.openMode;
    }

    public final NavigationSource getSource() {
        return this.source;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final TabAppType getTabAppType() {
        return this.tabAppType;
    }

    public final TabSite getTabSite() {
        return this.tabSite;
    }

    public final String getUniqueId() {
        return this.uniqueId;
    }

    public final boolean isErasable() {
        return this.isErasable;
    }

    public final boolean isPrimaryOnly() {
        return this.isPrimaryOnly;
    }

    public final boolean isUnmovable() {
        return this.isUnmovable;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TabAppInfo) == true) goto L8;
        return false;
    L8:
        TabAppInfo r101 = (TabAppInfo) r100;
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L11;
    L15:
        return false;
    L11:
        if (this.tabAppType != r101.tabAppType) goto L15;
        if (Intrinsics.areEqual(this.name, r101.name) == false) goto L15;
        return true;
    }

    public final void setTabSite(TabSite r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.tabSite = r100;
    }

    public TabAppInfo(String r100, String r101, TabAppType r102, Logo r103, Map<String, String> r104, Extra r105, boolean r106, boolean r107, TabSite r110, boolean r111, NavigationOpenMode r112, NavigationSource r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "uniqueId");
        Intrinsics.checkNotNullParameter(r102, "tabAppType");
        Intrinsics.checkNotNullParameter(r103, "logo");
        Intrinsics.checkNotNullParameter(r104, "name");
        Intrinsics.checkNotNullParameter(r105, "extra");
        Intrinsics.checkNotNullParameter(r110, "tabSite");
        Intrinsics.checkNotNullParameter(r114, "subTitle");
        this.key = r100;
        this.uniqueId = r101;
        this.tabAppType = r102;
        this.logo = r103;
        this.name = r104;
        this.extra = r105;
        this.isPrimaryOnly = r106;
        this.isUnmovable = r107;
        this.tabSite = r110;
        this.isErasable = r111;
        this.openMode = r112;
        this.source = r113;
        this.subTitle = r114;
    }

    public /* synthetic */ TabAppInfo(String r210, String r211, TabAppType r212, Logo r213, Map r214, Extra r215, boolean r216, boolean r217, TabSite r218, boolean r310, NavigationOpenMode r311, NavigationSource r312, String r313, int r314, DefaultConstructorMarker r315) {
        String r100 = "";
        if ((r314 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r314 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r314 & 4) == 0) goto L13;
        TabAppType r103 = TabAppType.APP_TYPE_NATIVE;
    L15:
        if ((r314 & 8) == 0) goto L17;
        Logo r104 = new Logo(null, null, null, null, null, null, null, null, null, 511, null);
    L19:
        if ((r314 & 16) == 0) goto L21;
        Map r105 = new HashMap();
    L23:
        if ((r314 & 32) == 0) goto L25;
        Extra r106 = new Extra(null, null, null, null, null, null, null, null, null, 511, null);
    L26:
        boolean r107 = false;
        if ((r314 & 64) == 0) goto L29;
        boolean r108 = false;
    L31:
        if ((r314 & 128) == 0) goto L33;
        boolean r110 = false;
    L35:
        if ((r314 & 256) == 0) goto L37;
        TabSite r111 = TabSite.OTHER;
    L39:
        if ((r314 & 512) != 0) goto L42;
        r107 = r310;
    L42:
        NavigationSource r112 = null;
        if ((r314 & 1024) == 0) goto L45;
        NavigationOpenMode r113 = null;
    L47:
        if ((r314 & 2048) != 0) goto L51;
        r112 = r312;
    L51:
        if ((r314 & 4096) != 0) goto L54;
        r100 = r313;
    L54:
        this(r101, r102, r103, r104, r105, r106, r108, r110, r111, r107, r113, r112, r100);
        return;
    L45:
        r113 = r311;
        goto L47
    L37:
        r111 = r218;
        goto L39
    L33:
        r110 = r217;
        goto L35
    L29:
        r108 = r216;
        goto L31
    L25:
        r106 = r215;
        goto L26
    L21:
        r105 = r214;
        goto L23
    L17:
        r104 = r213;
        goto L19
    L13:
        r103 = r212;
        goto L15
    L9:
        r102 = r211;
        goto L11
    L5:
        r101 = r210;
        goto L7
    }
}
