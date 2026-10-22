package com.bytedance.ee.bear.appsetting;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@AppConfig(key = EmergencyFixConfig.SETTING_KEY)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR:\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f\u0018\u0001`\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R:\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R2\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/appsetting/EmergencyFixConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "fgs", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getFgs", "()Ljava/util/HashMap;", "setFgs", "(Ljava/util/HashMap;)V", "settings", "getSettings", "setSettings", "cacheClean", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getCacheClean", "()Ljava/util/ArrayList;", "setCacheClean", "(Ljava/util/ArrayList;)V", "toString", "Companion", "base-app-setting_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EmergencyFixConfig implements NonProguard {
    public static final a Companion = null;
    public static final String SETTING_FG = "base.setting.realtime_fg_setting_fix";
    public static final String SETTING_KEY = "base_realtime_config_fix";

    @SerializedName("cache_clean")
    private ArrayList<String> cacheClean;
    private HashMap<String, Boolean> fgs;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f206230id;
    private HashMap<String, String> settings;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public EmergencyFixConfig() {
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("EmergencyFixConfig(id=");
        r100.append(this.f206230id);
        r100.append(", fgs=");
        HashMap<String, Boolean> r101 = this.fgs;
        Integer r102 = null;
        if (r101 == null) goto L5;
        Integer r103 = Integer.valueOf(r101.size());
    L6:
        r100.append(r103);
        r100.append(", settings=");
        HashMap<String, String> r104 = this.settings;
        if (r104 == null) goto L9;
        Integer r105 = Integer.valueOf(r104.size());
    L10:
        r100.append(r105);
        r100.append(", cacheClean=");
        ArrayList<String> r106 = this.cacheClean;
        if (r106 == null) goto L13;
        r102 = Integer.valueOf(r106.size());
    L13:
        r100.append(r102);
        r100.append(')');
        return r100.toString();
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    public final ArrayList<String> getCacheClean() {
        return this.cacheClean;
    }

    public final HashMap<String, Boolean> getFgs() {
        return this.fgs;
    }

    public final String getId() {
        return this.f206230id;
    }

    public final HashMap<String, String> getSettings() {
        return this.settings;
    }

    public final void setCacheClean(ArrayList<String> r100) {
        this.cacheClean = r100;
    }

    public final void setFgs(HashMap<String, Boolean> r100) {
        this.fgs = r100;
    }

    public final void setId(String r100) {
        this.f206230id = r100;
    }

    public final void setSettings(HashMap<String, String> r100) {
        this.settings = r100;
    }
}
