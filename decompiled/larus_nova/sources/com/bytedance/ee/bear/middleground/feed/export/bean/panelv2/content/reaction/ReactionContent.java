package com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.reaction;

import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.BaseContent;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.chat.api.service.track.sample.BaseSampleRecorder$Scene;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016R.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/middleground/feed/export/bean/panelv2/content/reaction/ReactionContent;", "Lcom/bytedance/ee/bear/middleground/feed/export/bean/panelv2/content/BaseContent;", "<init>", "()V", "reactions", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/middleground/feed/export/bean/panelv2/content/reaction/ReactionContent$Reaction;", "Lkotlin/collections/ArrayList;", "getReactions", "()Ljava/util/ArrayList;", "setReactions", "(Ljava/util/ArrayList;)V", "equals", "", "other", "", "hashCode", "", BaseSampleRecorder$Scene.REACTION, "middleground-feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReactionContent extends BaseContent {
    private ArrayList<Reaction> reactions;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/middleground/feed/export/bean/panelv2/content/reaction/ReactionContent$Reaction;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "key", "", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "equals", "", "other", "", "hashCode", "", "middleground-feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Reaction implements NonProguard {
        private String key;

        public int hashCode() {
            return this.key.hashCode();
        }

        public Reaction() {
            this.key = "";
        }

        public final String getKey() {
            return this.key;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Reaction) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.key, ((Reaction) r100).key) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final void setKey(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.key = r100;
        }
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.BaseContent, com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.IContent
    public int hashCode() {
        int r100 = super.hashCode() * 31;
        ArrayList<Reaction> r101 = this.reactions;
        if (r101 == null) goto L5;
        Object[] r102 = r101.toArray();
    L7:
        return r100 + Arrays.hashCode(r102);
    L5:
        r102 = null;
        goto L7
    }

    public ReactionContent() {
    }

    public final ArrayList<Reaction> getReactions() {
        return this.reactions;
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.BaseContent, com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.IContent
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ReactionContent) == true) goto L9;
        return false;
    L9:
        if (super.equals(r100) == true) goto L11;
        return false;
    L11:
        ArrayList<Reaction> r101 = this.reactions;
        Object[] r102 = null;
        if (r101 == null) goto L14;
        Object[] r103 = r101.toArray();
    L15:
        ArrayList<Reaction> r104 = ((ReactionContent) r100).reactions;
        if (r104 == null) goto L19;
        r102 = r104.toArray();
    L19:
        if (Arrays.equals(r103, r102) == true) goto L21;
        return false;
    L21:
        return true;
    L14:
        r103 = null;
        goto L15
    }

    public final void setReactions(ArrayList<Reaction> r100) {
        this.reactions = r100;
    }
}
