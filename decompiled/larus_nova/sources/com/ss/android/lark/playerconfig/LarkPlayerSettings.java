package com.ss.android.lark.playerconfig;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class LarkPlayerSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f438793a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f438794b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f438795c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f438796d = null;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t\u0012\u001c\b\u0002\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\t¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tHÆ\u0003J\u001d\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\tHÆ\u0003JY\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t2\u001c\b\u0002\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\tHÆ\u0001J\u0013\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R2\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R2\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019¨\u0006'"}, d2 = {"Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$EngineSetting;", "", "enableDebugLog", "", "nonStandard", "Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$NonStandardEngineSetting;", "base", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$SettingItem;", "Lkotlin/collections/ArrayList;", PromotionProductPrivilegesStruct.TAGS, "Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$TagItem;", "<init>", "(ZLcom/ss/android/lark/playerconfig/LarkPlayerSettings$NonStandardEngineSetting;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getEnableDebugLog", "()Z", "setEnableDebugLog", "(Z)V", "getNonStandard", "()Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$NonStandardEngineSetting;", "setNonStandard", "(Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$NonStandardEngineSetting;)V", "getBase", "()Ljava/util/ArrayList;", "setBase", "(Ljava/util/ArrayList;)V", "getTags", "setTags", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "playerconfig_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class EngineSetting {

        @SerializedName("base")
        private ArrayList<SettingItem> base;

        @SerializedName("enable_debug_log")
        private boolean enableDebugLog;

        @SerializedName("non_standard")
        private NonStandardEngineSetting nonStandard;

        @SerializedName(PromotionProductPrivilegesStruct.TAGS)
        private ArrayList<TagItem> tags;

        public EngineSetting() {
            this(false, null, null, null, 15, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ EngineSetting copy$default(EngineSetting r100, boolean r101, NonStandardEngineSetting r102, ArrayList r103, ArrayList r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.enableDebugLog;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.nonStandard;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.base;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.tags;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final boolean component1() {
            return this.enableDebugLog;
        }

        public final NonStandardEngineSetting component2() {
            return this.nonStandard;
        }

        public final ArrayList<SettingItem> component3() {
            return this.base;
        }

        public final ArrayList<TagItem> component4() {
            return this.tags;
        }

        public final EngineSetting copy(boolean r100, NonStandardEngineSetting r101, ArrayList<SettingItem> r102, ArrayList<TagItem> r103) {
            Intrinsics.checkNotNullParameter(r101, "nonStandard");
            return new EngineSetting(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof EngineSetting) == true) goto L8;
            return false;
        L8:
            EngineSetting r101 = (EngineSetting) r100;
            if (this.enableDebugLog == r101.enableDebugLog) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.nonStandard, r101.nonStandard) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.base, r101.base) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.tags, r101.tags) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            if (this.enableDebugLog == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = ((r100 * 31) + this.nonStandard.hashCode()) * 31;
            ArrayList<SettingItem> r102 = this.base;
            int r103 = 0;
            if (r102 != null) goto L9;
            int r104 = 0;
        L10:
            int r105 = (r101 + r104) * 31;
            ArrayList<TagItem> r106 = this.tags;
            if (r106 == null) goto L15;
            r103 = r106.hashCode();
        L15:
            return r105 + r103;
        L9:
            r104 = r102.hashCode();
            goto L10
        L5:
            r100 = 1237;
            goto L6
        }

        public String toString() {
            return "EngineSetting(enableDebugLog=" + this.enableDebugLog + ", nonStandard=" + this.nonStandard + ", base=" + this.base + ", tags=" + this.tags + ')';
        }

        public final ArrayList<SettingItem> getBase() {
            return this.base;
        }

        public final boolean getEnableDebugLog() {
            return this.enableDebugLog;
        }

        public final NonStandardEngineSetting getNonStandard() {
            return this.nonStandard;
        }

        public final ArrayList<TagItem> getTags() {
            return this.tags;
        }

        public final void setBase(ArrayList<SettingItem> r100) {
            this.base = r100;
        }

        public final void setEnableDebugLog(boolean r100) {
            this.enableDebugLog = r100;
        }

        public final void setNonStandard(NonStandardEngineSetting r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.nonStandard = r100;
        }

        public final void setTags(ArrayList<TagItem> r100) {
            this.tags = r100;
        }

        public EngineSetting(boolean r100, NonStandardEngineSetting r101, ArrayList<SettingItem> r102, ArrayList<TagItem> r103) {
            Intrinsics.checkNotNullParameter(r101, "nonStandard");
            this.enableDebugLog = r100;
            this.nonStandard = r101;
            this.base = r102;
            this.tags = r103;
        }

        public /* synthetic */ EngineSetting(boolean r100, NonStandardEngineSetting r101, ArrayList r110, ArrayList r111, int r112, DefaultConstructorMarker r113) {
            if ((r112 & 1) == 0) goto L6;
            r100 = false;
        L6:
            if ((r112 & 2) == 0) goto L9;
            r101 = new NonStandardEngineSetting(0, 0, 0, 0, 15, null);
        L9:
            if ((r112 & 4) == 0) goto L12;
            r110 = null;
        L12:
            if ((r112 & 8) == 0) goto L14;
            r111 = null;
        L14:
            this(r100, r101, r110, r111);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$LarkPlayerConfig;", "", "mdl", "Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$MDLSetting;", "engine", "Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$EngineSetting;", "<init>", "(Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$MDLSetting;Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$EngineSetting;)V", "getMdl", "()Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$MDLSetting;", "setMdl", "(Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$MDLSetting;)V", "getEngine", "()Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$EngineSetting;", "setEngine", "(Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$EngineSetting;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "playerconfig_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LarkPlayerConfig {

        @SerializedName("engine")
        private EngineSetting engine;

        @SerializedName("mdl")
        private MDLSetting mdl;

        /* JADX WARN: Multi-variable type inference failed */
        public LarkPlayerConfig() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ LarkPlayerConfig copy$default(LarkPlayerConfig r100, MDLSetting r101, EngineSetting r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.mdl;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.engine;
        L9:
            return r100.copy(r101, r102);
        }

        public final MDLSetting component1() {
            return this.mdl;
        }

        public final EngineSetting component2() {
            return this.engine;
        }

        public final LarkPlayerConfig copy(MDLSetting r100, EngineSetting r101) {
            Intrinsics.checkNotNullParameter(r100, "mdl");
            Intrinsics.checkNotNullParameter(r101, "engine");
            return new LarkPlayerConfig(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof LarkPlayerConfig) == true) goto L8;
            return false;
        L8:
            LarkPlayerConfig r101 = (LarkPlayerConfig) r100;
            if (Intrinsics.areEqual(this.mdl, r101.mdl) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.engine, r101.engine) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.mdl.hashCode() * 31) + this.engine.hashCode();
        }

        public String toString() {
            return "LarkPlayerConfig(mdl=" + this.mdl + ", engine=" + this.engine + ')';
        }

        public final EngineSetting getEngine() {
            return this.engine;
        }

        public final MDLSetting getMdl() {
            return this.mdl;
        }

        public final void setEngine(EngineSetting r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.engine = r100;
        }

        public final void setMdl(MDLSetting r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.mdl = r100;
        }

        public LarkPlayerConfig(MDLSetting r100, EngineSetting r101) {
            Intrinsics.checkNotNullParameter(r100, "mdl");
            Intrinsics.checkNotNullParameter(r101, "engine");
            this.mdl = r100;
            this.engine = r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ LarkPlayerConfig(MDLSetting r100, EngineSetting r101, int r110, DefaultConstructorMarker r111) {
            if ((r110 & 1) == 0) goto L6;
            NonStandardMDLSetting r102 = null;
            Object[] r103 = 0 == true ? 1 : 0;
            r100 = new MDLSetting(r102, r103, 3, 0 == true ? 1 : 0);
        L6:
            if ((r110 & 2) == 0) goto L8;
            r101 = new EngineSetting(false, null, null, null, 15, null);
        L8:
            this(r100, r101);
        }
    }

    @AppConfig(key = "lark_player_settings")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$LarkPlayerSetting;", "", "<init>", "()V", "playerconfig_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LarkPlayerSetting {
        public LarkPlayerSetting() {
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR2\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$MDLSetting;", "", "nonStandard", "Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$NonStandardMDLSetting;", "base", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$SettingItem;", "Lkotlin/collections/ArrayList;", "<init>", "(Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$NonStandardMDLSetting;Ljava/util/ArrayList;)V", "getNonStandard", "()Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$NonStandardMDLSetting;", "setNonStandard", "(Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$NonStandardMDLSetting;)V", "getBase", "()Ljava/util/ArrayList;", "setBase", "(Ljava/util/ArrayList;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "playerconfig_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MDLSetting {

        @SerializedName("base")
        private ArrayList<SettingItem> base;

        @SerializedName("non_standard")
        private NonStandardMDLSetting nonStandard;

        /* JADX WARN: Multi-variable type inference failed */
        public MDLSetting() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MDLSetting copy$default(MDLSetting r100, NonStandardMDLSetting r101, ArrayList r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.nonStandard;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.base;
        L9:
            return r100.copy(r101, r102);
        }

        public final NonStandardMDLSetting component1() {
            return this.nonStandard;
        }

        public final ArrayList<SettingItem> component2() {
            return this.base;
        }

        public final MDLSetting copy(NonStandardMDLSetting r100, ArrayList<SettingItem> r101) {
            Intrinsics.checkNotNullParameter(r100, "nonStandard");
            return new MDLSetting(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof MDLSetting) == true) goto L8;
            return false;
        L8:
            MDLSetting r101 = (MDLSetting) r100;
            if (Intrinsics.areEqual(this.nonStandard, r101.nonStandard) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.base, r101.base) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r100 = this.nonStandard.hashCode() * 31;
            ArrayList<SettingItem> r101 = this.base;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public String toString() {
            return "MDLSetting(nonStandard=" + this.nonStandard + ", base=" + this.base + ')';
        }

        public final ArrayList<SettingItem> getBase() {
            return this.base;
        }

        public final NonStandardMDLSetting getNonStandard() {
            return this.nonStandard;
        }

        public final void setBase(ArrayList<SettingItem> r100) {
            this.base = r100;
        }

        public final void setNonStandard(NonStandardMDLSetting r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.nonStandard = r100;
        }

        public MDLSetting(NonStandardMDLSetting r100, ArrayList<SettingItem> r101) {
            Intrinsics.checkNotNullParameter(r100, "nonStandard");
            this.nonStandard = r100;
            this.base = r101;
        }

        public /* synthetic */ MDLSetting(NonStandardMDLSetting r100, ArrayList r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = new NonStandardMDLSetting();
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$NonStandardEngineSetting;", "", "engineType", "", "enableLooper", "setCacheControlEnabled", "codecID", "<init>", "(IIII)V", "getEngineType", "()I", "setEngineType", "(I)V", "getEnableLooper", "setEnableLooper", "getSetCacheControlEnabled", "setSetCacheControlEnabled", "getCodecID", "setCodecID", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "playerconfig_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NonStandardEngineSetting {

        @SerializedName("ASYNC_INIT_CODEC_ID")
        private int codecID;

        @SerializedName("ENGINE_PARAM_KEY_ENABLE_LOOPER")
        private int enableLooper;

        @SerializedName("ENGINE_TYPE")
        private int engineType;

        @SerializedName("SET_CACHE_CONTROL_ENABLED")
        private int setCacheControlEnabled;

        public NonStandardEngineSetting() {
            this(0, 0, 0, 0, 15, null);
        }

        public static /* synthetic */ NonStandardEngineSetting copy$default(NonStandardEngineSetting r100, int r101, int r102, int r103, int r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.engineType;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.enableLooper;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.setCacheControlEnabled;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.codecID;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final int component1() {
            return this.engineType;
        }

        public final int component2() {
            return this.enableLooper;
        }

        public final int component3() {
            return this.setCacheControlEnabled;
        }

        public final int component4() {
            return this.codecID;
        }

        public final NonStandardEngineSetting copy(int r100, int r101, int r102, int r103) {
            return new NonStandardEngineSetting(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof NonStandardEngineSetting) == true) goto L8;
            return false;
        L8:
            NonStandardEngineSetting r101 = (NonStandardEngineSetting) r100;
            if (this.engineType == r101.engineType) goto L12;
            return false;
        L12:
            if (this.enableLooper == r101.enableLooper) goto L15;
            return false;
        L15:
            if (this.setCacheControlEnabled == r101.setCacheControlEnabled) goto L18;
            return false;
        L18:
            if (this.codecID == r101.codecID) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.engineType * 31) + this.enableLooper) * 31) + this.setCacheControlEnabled) * 31) + this.codecID;
        }

        public String toString() {
            return "NonStandardEngineSetting(engineType=" + this.engineType + ", enableLooper=" + this.enableLooper + ", setCacheControlEnabled=" + this.setCacheControlEnabled + ", codecID=" + this.codecID + ')';
        }

        public final int getCodecID() {
            return this.codecID;
        }

        public final int getEnableLooper() {
            return this.enableLooper;
        }

        public final int getEngineType() {
            return this.engineType;
        }

        public final int getSetCacheControlEnabled() {
            return this.setCacheControlEnabled;
        }

        public final void setCodecID(int r100) {
            this.codecID = r100;
        }

        public final void setEnableLooper(int r100) {
            this.enableLooper = r100;
        }

        public final void setEngineType(int r100) {
            this.engineType = r100;
        }

        public final void setSetCacheControlEnabled(int r100) {
            this.setCacheControlEnabled = r100;
        }

        public NonStandardEngineSetting(int r100, int r101, int r102, int r103) {
            this.engineType = r100;
            this.enableLooper = r101;
            this.setCacheControlEnabled = r102;
            this.codecID = r103;
        }

        public /* synthetic */ NonStandardEngineSetting(int r100, int r101, int r102, int r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 1) == 0) goto L6;
            r100 = 0;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r101 = 1;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r102 = 1;
        L12:
            if ((r104 & 8) == 0) goto L14;
            r103 = 0;
        L14:
            this(r100, r101, r102, r103);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$NonStandardMDLSetting;", "", "<init>", "()V", "playerconfig_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NonStandardMDLSetting {
        public NonStandardMDLSetting() {
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J3\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0004\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015¨\u0006\""}, d2 = {"Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$SettingItem;", "", "key", "", "value", "type", "", SocialConstants.PARAM_APP_DESC, "<init>", "(ILjava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()I", "setKey", "(I)V", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "getDesc", "setDesc", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "playerconfig_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SettingItem {

        @SerializedName(SocialConstants.PARAM_APP_DESC)
        private String desc;

        @SerializedName("key")
        private int key;

        @SerializedName("type")
        private String type;

        @SerializedName("value")
        private Object value;

        public SettingItem() {
            this(0, null, null, null, 15, null);
        }

        public static /* synthetic */ SettingItem copy$default(SettingItem r100, int r101, Object r102, String r103, String r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.key;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.value;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.type;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.desc;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final int component1() {
            return this.key;
        }

        public final Object component2() {
            return this.value;
        }

        public final String component3() {
            return this.type;
        }

        public final String component4() {
            return this.desc;
        }

        public final SettingItem copy(int r100, Object r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r102, "type");
            Intrinsics.checkNotNullParameter(r103, SocialConstants.PARAM_APP_DESC);
            return new SettingItem(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof SettingItem) == true) goto L8;
            return false;
        L8:
            SettingItem r101 = (SettingItem) r100;
            if (this.key == r101.key) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.value, r101.value) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.type, r101.type) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.desc, r101.desc) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r100 = this.key * 31;
            Object r101 = this.value;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return ((((r100 + r102) * 31) + this.type.hashCode()) * 31) + this.desc.hashCode();
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public String toString() {
            return "SettingItem(key=" + this.key + ", value=" + this.value + ", type=" + this.type + ", desc=" + this.desc + ')';
        }

        public final String getDesc() {
            return this.desc;
        }

        public final int getKey() {
            return this.key;
        }

        public final String getType() {
            return this.type;
        }

        public final Object getValue() {
            return this.value;
        }

        public final void setDesc(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.desc = r100;
        }

        public final void setKey(int r100) {
            this.key = r100;
        }

        public final void setType(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.type = r100;
        }

        public final void setValue(Object r100) {
            this.value = r100;
        }

        public SettingItem(int r100, Object r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r102, "type");
            Intrinsics.checkNotNullParameter(r103, SocialConstants.PARAM_APP_DESC);
            this.key = r100;
            this.value = r101;
            this.type = r102;
            this.desc = r103;
        }

        public /* synthetic */ SettingItem(int r100, Object r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 1) == 0) goto L6;
            r100 = Integer.MAX_VALUE;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r101 = null;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r102 = "";
        L12:
            if ((r104 & 8) == 0) goto L14;
            r103 = "";
        L14:
            this(r100, r101, r102, r103);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR2\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$SubTagItem;", "", "name", "", "base", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$SettingItem;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/String;Ljava/util/ArrayList;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getBase", "()Ljava/util/ArrayList;", "setBase", "(Ljava/util/ArrayList;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "playerconfig_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SubTagItem {

        @SerializedName("base")
        private ArrayList<SettingItem> base;

        @SerializedName("name")
        private String name;

        /* JADX WARN: Multi-variable type inference failed */
        public SubTagItem() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SubTagItem copy$default(SubTagItem r100, String r101, ArrayList r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.name;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.base;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.name;
        }

        public final ArrayList<SettingItem> component2() {
            return this.base;
        }

        public final SubTagItem copy(String r100, ArrayList<SettingItem> r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
            return new SubTagItem(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof SubTagItem) == true) goto L8;
            return false;
        L8:
            SubTagItem r101 = (SubTagItem) r100;
            if (Intrinsics.areEqual(this.name, r101.name) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.base, r101.base) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r100 = this.name.hashCode() * 31;
            ArrayList<SettingItem> r101 = this.base;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public String toString() {
            return "SubTagItem(name=" + this.name + ", base=" + this.base + ')';
        }

        public final ArrayList<SettingItem> getBase() {
            return this.base;
        }

        public final String getName() {
            return this.name;
        }

        public final void setBase(ArrayList<SettingItem> r100) {
            this.base = r100;
        }

        public final void setName(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.name = r100;
        }

        public SubTagItem(String r100, ArrayList<SettingItem> r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
            this.name = r100;
            this.base = r101;
        }

        public /* synthetic */ SubTagItem(String r100, ArrayList r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this(r100, r101);
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007\u0012\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u0007¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J\u001d\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u0007HÆ\u0003JO\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00072\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR2\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R2\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013¨\u0006 "}, d2 = {"Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$TagItem;", "", "name", "", "base", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$SettingItem;", "Lkotlin/collections/ArrayList;", "subTags", "Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$SubTagItem;", "<init>", "(Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getBase", "()Ljava/util/ArrayList;", "setBase", "(Ljava/util/ArrayList;)V", "getSubTags", "setSubTags", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "playerconfig_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TagItem {

        @SerializedName("base")
        private ArrayList<SettingItem> base;

        @SerializedName("name")
        private String name;

        @SerializedName("subtags")
        private ArrayList<SubTagItem> subTags;

        public TagItem() {
            this(null, null, null, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TagItem copy$default(TagItem r100, String r101, ArrayList r102, ArrayList r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.name;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.base;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.subTags;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final String component1() {
            return this.name;
        }

        public final ArrayList<SettingItem> component2() {
            return this.base;
        }

        public final ArrayList<SubTagItem> component3() {
            return this.subTags;
        }

        public final TagItem copy(String r100, ArrayList<SettingItem> r101, ArrayList<SubTagItem> r102) {
            Intrinsics.checkNotNullParameter(r100, "name");
            return new TagItem(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof TagItem) == true) goto L8;
            return false;
        L8:
            TagItem r101 = (TagItem) r100;
            if (Intrinsics.areEqual(this.name, r101.name) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.base, r101.base) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.subTags, r101.subTags) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r100 = this.name.hashCode() * 31;
            ArrayList<SettingItem> r101 = this.base;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            ArrayList<SubTagItem> r105 = this.subTags;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return r104 + r102;
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public String toString() {
            return "TagItem(name=" + this.name + ", base=" + this.base + ", subTags=" + this.subTags + ')';
        }

        public final ArrayList<SettingItem> getBase() {
            return this.base;
        }

        public final String getName() {
            return this.name;
        }

        public final ArrayList<SubTagItem> getSubTags() {
            return this.subTags;
        }

        public final void setBase(ArrayList<SettingItem> r100) {
            this.base = r100;
        }

        public final void setName(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.name = r100;
        }

        public final void setSubTags(ArrayList<SubTagItem> r100) {
            this.subTags = r100;
        }

        public TagItem(String r100, ArrayList<SettingItem> r101, ArrayList<SubTagItem> r102) {
            Intrinsics.checkNotNullParameter(r100, "name");
            this.name = r100;
            this.base = r101;
            this.subTags = r102;
        }

        public /* synthetic */ TagItem(String r100, ArrayList r101, ArrayList r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = null;
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = null;
        L11:
            this(r100, r101, r102);
        }
    }

    public LarkPlayerSettings() {
    }

    static {
        f438793a = LazyKt.lazy(LarkPlayerSettings$remoteSetting$2.INSTANCE);
        f438794b = LazyKt.lazy(LarkPlayerSettings$switchConfig$2.INSTANCE);
        f438795c = LazyKt.lazy(LarkPlayerSettings$mdl$2.INSTANCE);
        f438796d = LazyKt.lazy(LarkPlayerSettings$engine$2.INSTANCE);
    }
}
