package com.bytedance.ee.bear.block.jira;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/block/jira/PublicJiraConfig$DefaultConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "jiraConfig", "Lcom/bytedance/ee/bear/block/jira/PublicJiraConfig$DefaultConfig$JiraConfigBean;", "getJiraConfig", "()Lcom/bytedance/ee/bear/block/jira/PublicJiraConfig$DefaultConfig$JiraConfigBean;", "setJiraConfig", "(Lcom/bytedance/ee/bear/block/jira/PublicJiraConfig$DefaultConfig$JiraConfigBean;)V", "JiraConfigBean", "features-block-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PublicJiraConfig$DefaultConfig implements NonProguard {
    private JiraConfigBean jiraConfig;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/block/jira/PublicJiraConfig$DefaultConfig$JiraConfigBean;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "linkInterceptConfig", "Lcom/bytedance/ee/bear/block/jira/PublicJiraConfig$DefaultConfig$JiraConfigBean$LinkInterceptConfigBean;", "getLinkInterceptConfig", "()Lcom/bytedance/ee/bear/block/jira/PublicJiraConfig$DefaultConfig$JiraConfigBean$LinkInterceptConfigBean;", "setLinkInterceptConfig", "(Lcom/bytedance/ee/bear/block/jira/PublicJiraConfig$DefaultConfig$JiraConfigBean$LinkInterceptConfigBean;)V", "LinkInterceptConfigBean", "features-block-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class JiraConfigBean implements NonProguard {
        private LinkInterceptConfigBean linkInterceptConfig;

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/block/jira/PublicJiraConfig$DefaultConfig$JiraConfigBean$LinkInterceptConfigBean;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "isEnable", "", "()Z", "setEnable", "(Z)V", "packageName", "", "getPackageName", "()Ljava/lang/String;", "setPackageName", "(Ljava/lang/String;)V", "domain", "", "getDomain", "()Ljava/util/List;", "setDomain", "(Ljava/util/List;)V", "topDomain", "getTopDomain", "setTopDomain", "features-block-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class LinkInterceptConfigBean implements NonProguard {
            private List<String> domain;
            private boolean isEnable;
            private String packageName;
            private List<String> topDomain;

            public LinkInterceptConfigBean() {
                this.isEnable = true;
                this.packageName = "com.atlassian.android.jira.core";
                this.domain = CollectionsKt.mutableListOf(new String[]{"atlassian.net", "id.atlassian.com", "id.dev.internal.atlassian.com", "com.atlassian.android.jira.core", "id.stg.internal.atlassian.com"});
                this.topDomain = CollectionsKt.mutableListOf(new String[]{"atlassian.net", "jira.com", "jira-dev.com"});
            }

            public final List<String> getDomain() {
                return this.domain;
            }

            public final String getPackageName() {
                return this.packageName;
            }

            public final List<String> getTopDomain() {
                return this.topDomain;
            }

            public final boolean isEnable() {
                return this.isEnable;
            }

            public final void setDomain(List<String> r2) {
                Intrinsics.checkNotNullParameter(r2, "<set-?>");
                this.domain = r2;
            }

            public final void setEnable(boolean r1) {
                this.isEnable = r1;
            }

            public final void setPackageName(String r2) {
                Intrinsics.checkNotNullParameter(r2, "<set-?>");
                this.packageName = r2;
            }

            public final void setTopDomain(List<String> r2) {
                Intrinsics.checkNotNullParameter(r2, "<set-?>");
                this.topDomain = r2;
            }
        }

        public JiraConfigBean() {
            this.linkInterceptConfig = new LinkInterceptConfigBean();
        }

        public final LinkInterceptConfigBean getLinkInterceptConfig() {
            return this.linkInterceptConfig;
        }

        public final void setLinkInterceptConfig(LinkInterceptConfigBean r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.linkInterceptConfig = r2;
        }
    }

    public PublicJiraConfig$DefaultConfig() {
        this.jiraConfig = new JiraConfigBean();
    }

    public final JiraConfigBean getJiraConfig() {
        return this.jiraConfig;
    }

    public final void setJiraConfig(JiraConfigBean r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.jiraConfig = r2;
    }
}
