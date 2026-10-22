package wf5;

import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.ContentWraper;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.IContent;
import com.google.gson.JsonElement;

/* JADX INFO: loaded from: classes18.dex */
public interface a<Content extends IContent> {
    ContentWraper<Content> a(String r100, JsonElement r101);
}
