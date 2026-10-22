package com.larus.platform.model.bot;

import com.google.gson.annotations.SerializedName;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0013\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J.\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/larus/platform/model/bot/MultiBotsStatusUIFixConfig;", "", "enabled", "", "serviceBotLinkAllowlist", "", "", "<init>", "(Ljava/lang/Boolean;Ljava/util/List;)V", "getEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getServiceBotLinkAllowlist", "()Ljava/util/List;", "isEnabled", "()Z", "isServiceBotLinkAllowed", "botId", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/util/List;)Lcom/larus/platform/model/bot/MultiBotsStatusUIFixConfig;", "equals", "other", "hashCode", "", "toString", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultiBotsStatusUIFixConfig {
    public static final a Companion = null;
    private static final List<String> DEFAULT_SERVICE_BOT_LINK_ALLOWLIST = null;

    @SerializedName("enabled")
    private final Boolean enabled;

    @SerializedName("service_bot_link_allowlist")
    private final List<String> serviceBotLinkAllowlist;

    public static final class a {
        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MultiBotsStatusUIFixConfig() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MultiBotsStatusUIFixConfig copy$default(MultiBotsStatusUIFixConfig r100, Boolean r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.enabled;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.serviceBotLinkAllowlist;
    L9:
        return r100.copy(r101, r102);
    }

    public final Boolean component1() {
        return this.enabled;
    }

    public final List<String> component2() {
        return this.serviceBotLinkAllowlist;
    }

    public final MultiBotsStatusUIFixConfig copy(Boolean r100, List<String> r101) {
        return new MultiBotsStatusUIFixConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MultiBotsStatusUIFixConfig) == true) goto L8;
        return false;
    L8:
        MultiBotsStatusUIFixConfig r101 = (MultiBotsStatusUIFixConfig) r100;
        if (Intrinsics.areEqual(this.enabled, r101.enabled) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.serviceBotLinkAllowlist, r101.serviceBotLinkAllowlist) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Boolean r100 = this.enabled;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.serviceBotLinkAllowlist;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "MultiBotsStatusUIFixConfig(enabled=" + this.enabled + ", serviceBotLinkAllowlist=" + this.serviceBotLinkAllowlist + ')';
    }

    static {
        Companion = new a();
        DEFAULT_SERVICE_BOT_LINK_ALLOWLIST = CollectionsKt.listOf(new String[]{"7626957768951480347", "7612964097608597538"});
    }

    public final boolean isEnabled() {
        Boolean r100 = this.enabled;
        if (r100 != null) goto L7;
        return true;
    L7:
        return r100.booleanValue();
    }

    public final Boolean getEnabled() {
        return this.enabled;
    }

    public final List<String> getServiceBotLinkAllowlist() {
        return this.serviceBotLinkAllowlist;
    }

    public final boolean isServiceBotLinkAllowed(String r100) {
        if (isEnabled() == true) goto L5;
        return false;
    L5:
        if (r100 != null) goto L7;
    L10:
        boolean r101 = true;
    L11:
        if (r101 == true) goto L32;
        List<String> r102 = this.serviceBotLinkAllowlist;
        if (r102 != null) goto L16;
        r102 = DEFAULT_SERVICE_BOT_LINK_ALLOWLIST;
    L16:
        List<String> r103 = r102;
        if ((r103 instanceof Collection) == true) goto L19;
    L21:
        Iterator<T> r104 = r103.iterator();
    L23:
        if (r104.hasNext() == false) goto L34;
        if (Intrinsics.areEqual((String) r104.next(), r100) == false) goto L23;
        return true;
    L34:
        return false;
    L19:
        if (r103.isEmpty() == false) goto L21;
        return false;
    L32:
        return false;
    L7:
        if (StringsKt.isBlank(r100) == true) goto L10;
        r101 = false;
        goto L11
    }

    public MultiBotsStatusUIFixConfig(Boolean r100, List<String> r101) {
        this.enabled = r100;
        this.serviceBotLinkAllowlist = r101;
    }

    public /* synthetic */ MultiBotsStatusUIFixConfig(Boolean r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = Boolean.TRUE;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = DEFAULT_SERVICE_BOT_LINK_ALLOWLIST;
    L8:
        this(r100, r101);
    }
}
