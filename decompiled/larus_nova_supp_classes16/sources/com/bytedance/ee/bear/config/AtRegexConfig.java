package com.bytedance.ee.bear.config;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@AppConfig(key = AtRegexConfig.KEY)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR.\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/config/AtRegexConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "linkRegex", "", "getLinkRegex", "()Ljava/lang/String;", "setLinkRegex", "(Ljava/lang/String;)V", "newRuleEnable", "", "getNewRuleEnable", "()Z", "setNewRuleEnable", "(Z)V", "blackSuffixList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getBlackSuffixList", "()Ljava/util/ArrayList;", "setBlackSuffixList", "(Ljava/util/ArrayList;)V", "Companion", "features-at_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AtRegexConfig implements NonProguard {
    public static final a Companion = null;
    public static final String KEY = "ccm_at_regex_config";
    private ArrayList<String> blackSuffixList;
    private String linkRegex;
    private boolean newRuleEnable;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public AtRegexConfig() {
    }

    public final ArrayList<String> getBlackSuffixList() {
        return this.blackSuffixList;
    }

    public final String getLinkRegex() {
        return this.linkRegex;
    }

    public final boolean getNewRuleEnable() {
        return this.newRuleEnable;
    }

    public final void setBlackSuffixList(ArrayList<String> r1) {
        this.blackSuffixList = r1;
    }

    public final void setLinkRegex(String r1) {
        this.linkRegex = r1;
    }

    public final void setNewRuleEnable(boolean r1) {
        this.newRuleEnable = r1;
    }
}
