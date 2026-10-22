package com.ss.android.lark.feed.app.entity;

import com.ss.android.lark.biz.im.api.FeedPreviewInfo;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0002\u0010\u0011B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000f\u001a\u00020\u0007H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/feed/app/entity/FeedEntity;", "", "previews", "", "Lcom/ss/android/lark/biz/im/api/FeedPreviewInfo;", "feedFolderMap", "", "", "Lcom/ss/android/lark/feed/app/entity/FeedEntity$FeedFolderRules;", "<init>", "(Ljava/util/List;Ljava/util/Map;)V", "getPreviews", "()Ljava/util/List;", "getFeedFolderMap", "()Ljava/util/Map;", "toString", "FeedFolderRules", "FolderRuleList", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedEntity {
    private final Map<String, FeedFolderRules> feedFolderMap;
    private final List<FeedPreviewInfo> previews;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/feed/app/entity/FeedEntity$FeedFolderRules;", "", "folderMap", "", "", "Lcom/ss/android/lark/feed/app/entity/FeedEntity$FolderRuleList;", "<init>", "(Ljava/util/Map;)V", "getFolderMap", "()Ljava/util/Map;", "toString", "", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FeedFolderRules {
        private final Map<Long, FolderRuleList> folderMap;

        public String toString() {
            return "FeedFolderRules(folderMap=" + this.folderMap + ')';
        }

        public final Map<Long, FolderRuleList> getFolderMap() {
            return this.folderMap;
        }

        public FeedFolderRules(Map<Long, FolderRuleList> r100) {
            Intrinsics.checkNotNullParameter(r100, "folderMap");
            this.folderMap = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/feed/app/entity/FeedEntity$FolderRuleList;", "", "rules", "", "Lcom/ss/android/lark/feed/app/entity/FeedFolderRule;", "<init>", "(Ljava/util/List;)V", "getRules", "()Ljava/util/List;", "toString", "", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FolderRuleList {
        private final List<FeedFolderRule> rules;

        public String toString() {
            return "FolderRuleList(rules=" + this.rules + ')';
        }

        public final List<FeedFolderRule> getRules() {
            return this.rules;
        }

        public FolderRuleList(List<FeedFolderRule> r100) {
            Intrinsics.checkNotNullParameter(r100, "rules");
            this.rules = r100;
        }
    }

    public String toString() {
        return "FeedEntity(previews=" + this.previews + ", feedFolderMap=" + this.feedFolderMap + ')';
    }

    public final Map<String, FeedFolderRules> getFeedFolderMap() {
        return this.feedFolderMap;
    }

    public final List<FeedPreviewInfo> getPreviews() {
        return this.previews;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FeedEntity(List<? extends FeedPreviewInfo> r100, Map<String, FeedFolderRules> r101) {
        Intrinsics.checkNotNullParameter(r100, "previews");
        Intrinsics.checkNotNullParameter(r101, "feedFolderMap");
        this.previews = r100;
        this.feedFolderMap = r101;
    }
}
