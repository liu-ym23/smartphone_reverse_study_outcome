package com.bytedance.ee.bear.block.jira;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.util.io.NonProguard;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001b\u001a\u00020\u001cR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR$\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/block/jira/JiraActionData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", WikiFolderPushPlugin.BLOCK_ID, "", "getBlockId", "()Ljava/lang/String;", "setBlockId", "(Ljava/lang/String;)V", "id", "getId", "setId", "title", "getTitle", com.alipay.sdk.m.x.d.f25925o, SocialConstants.PARAM_APP_DESC, "getDesc", "setDesc", SlcCommonAction.KEY_ACTIONS, "", "Lcom/bytedance/ee/bear/block/jira/JiraActionData$ActionSheetItem;", "getActions", "()[Lcom/bytedance/ee/bear/block/jira/JiraActionData$ActionSheetItem;", "setActions", "([Lcom/bytedance/ee/bear/block/jira/JiraActionData$ActionSheetItem;)V", "[Lcom/bytedance/ee/bear/block/jira/JiraActionData$ActionSheetItem;", "isEmpty", "", "ActionSheetItem", "features-block-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JiraActionData implements NonProguard {
    private ActionSheetItem[] actions;
    private String blockId;
    private String desc;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f216570id;
    private String title;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/block/jira/JiraActionData$ActionSheetItem;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "id", "getId", "setId", "enable", "", "getEnable", "()Ljava/lang/Boolean;", "setEnable", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "features-block-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ActionSheetItem implements NonProguard {
        private Boolean enable;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private String f216571id;
        private String text;

        public ActionSheetItem() {
        }

        public final Boolean getEnable() {
            return this.enable;
        }

        public final String getId() {
            return this.f216571id;
        }

        public final String getText() {
            return this.text;
        }

        public final void setEnable(Boolean r100) {
            this.enable = r100;
        }

        public final void setId(String r100) {
            this.f216571id = r100;
        }

        public final void setText(String r100) {
            this.text = r100;
        }
    }

    public JiraActionData() {
    }

    public final boolean isEmpty() {
        if (this.blockId == null) goto L5;
    L9:
        return false;
    L5:
        if (this.f216570id != null) goto L9;
        if (this.actions != null) goto L9;
        return true;
    }

    public final ActionSheetItem[] getActions() {
        return this.actions;
    }

    public final String getBlockId() {
        return this.blockId;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getId() {
        return this.f216570id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setActions(ActionSheetItem[] r100) {
        this.actions = r100;
    }

    public final void setBlockId(String r100) {
        this.blockId = r100;
    }

    public final void setDesc(String r100) {
        this.desc = r100;
    }

    public final void setId(String r100) {
        this.f216570id = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }
}
