package com.larus.settings.protector;

import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/larus/settings/protector/DefaultProtectorConfig;", "", "enable", "", "list", "Lcom/google/gson/JsonArray;", "<init>", "(ZLcom/google/gson/JsonArray;)V", "getEnable", "()Z", "getList", "()Lcom/google/gson/JsonArray;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultProtectorConfig {
    public static final a Companion = null;
    private static final DefaultProtectorConfig DEFAULT = null;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("list")
    private final JsonArray list;

    public static final class a {
        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultProtectorConfig() {
        boolean r100 = false;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ DefaultProtectorConfig copy$default(DefaultProtectorConfig r100, boolean r101, JsonArray r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.enable;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.list;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final JsonArray component2() {
        return this.list;
    }

    public final DefaultProtectorConfig copy(boolean r100, JsonArray r101) {
        return new DefaultProtectorConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DefaultProtectorConfig) == true) goto L8;
        return false;
    L8:
        DefaultProtectorConfig r101 = (DefaultProtectorConfig) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.list, r101.list) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        if (this.enable == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        JsonArray r102 = this.list;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "DefaultProtectorConfig(enable=" + this.enable + ", list=" + this.list + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Companion = new a();
        JsonArray r100 = null;
        DEFAULT = new DefaultProtectorConfig(false, r100, 3, 0 == true ? 1 : 0);
    }

    public static final /* synthetic */ DefaultProtectorConfig access$getDEFAULT$cp() {
        return DEFAULT;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final JsonArray getList() {
        return this.list;
    }

    public DefaultProtectorConfig(boolean r100, JsonArray r101) {
        this.enable = r100;
        this.list = r101;
    }

    public /* synthetic */ DefaultProtectorConfig(boolean r100, JsonArray r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = new JsonArray();
    L8:
        this(r100, r101);
    }
}
