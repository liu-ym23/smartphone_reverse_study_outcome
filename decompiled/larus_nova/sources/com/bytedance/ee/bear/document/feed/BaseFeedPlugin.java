package com.bytedance.ee.bear.document.feed;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\nH&J\u0016\u0010\u000b\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&J\b\u0010\u000f\u001a\u00020\u0005H&¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/document/feed/BaseFeedPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "<init>", "()V", "addJumpToCommentListener", "", "listener", "Lcom/bytedance/ee/bear/document/feed/BaseFeedPlugin$JumpToCommentListener;", "removeJumpToCommentListener", "isShowing", "", JSEventListener.ACTION_READMESSAGE, "messageId", "", "", "hideWithAnim", "JumpToCommentListener", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseFeedPlugin extends DocumentPlugin {

    public interface a {
        void a();
    }

    public abstract void addJumpToCommentListener(a r100);

    public abstract void hideWithAnim();

    public abstract boolean isShowing();

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public abstract void readMessage(List<String> r100);

    public abstract void removeJumpToCommentListener(a r100);

    public BaseFeedPlugin() {
    }
}
