package com.larus.bmhome.collection;

import by7.e;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.CancelCollectionResponse;
import com.larus.platform.model.SaveCollectionResponse;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH&JT\u0010\n\u001a\u00020\u00032\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&Jb\u0010\u0015\u001a\u00020\u00032\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\f2\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/collection/ICollectionReport;", "", "clickButton", "", "collectionId", "", "buttonName", "followingOtherAction", "trackNode", "Lcom/ixigua/lib/track/ITrackNode;", "messageCollect", "collectResult", "Lcom/larus/network/http/Async;", "Lcom/larus/platform/model/SaveCollectionResponse;", "messages", "", "Lcom/larus/im/bean/message/Message;", "clickFrom", "currentPage", "traceInfo", "Lorg/json/JSONObject;", "messageCollectCancel", "collectCancelResult", "Lcom/larus/platform/model/CancelCollectionResponse;", "botId", "conversationId", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ICollectionReport {

    public static final class a {
        public static /* synthetic */ void a(CollectionReportDelegate r100, com.larus.network.http.a r110, List r111, String r112, String r113, String r114, JSONObject r115, int r116) {
            if ((r116 & 16) == 0) goto L5;
            String r101 = null;
        L7:
            if ((r116 & 32) == 0) goto L9;
            JSONObject r102 = null;
        L10:
            r100.c(r110, r111, r112, r113, r101, r102);
            return;
        L9:
            r102 = r115;
            goto L10
        L5:
            r101 = r114;
            goto L7
        }

        public static /* synthetic */ void b(CollectionReportDelegate r110, com.larus.network.http.a r111, List r112, String r113, String r114, String r115, String r116, int r117) {
            if ((r117 & 8) == 0) goto L5;
            String r100 = null;
        L7:
            if ((r117 & 16) == 0) goto L9;
            String r101 = null;
        L11:
            if ((r117 & 32) == 0) goto L13;
            String r102 = null;
        L14:
            r110.b(r111, r112, r113, r100, r101, r102, null);
            return;
        L13:
            r102 = r116;
            goto L14
        L9:
            r101 = r115;
            goto L11
        L5:
            r100 = r114;
            goto L7
        }
    }

    void a(String r100, String r101, String r102, e r103);

    void b(com.larus.network.http.a<CancelCollectionResponse> r100, List<Message> r101, String r102, String r103, String r104, String r105, e r106);

    void c(com.larus.network.http.a<SaveCollectionResponse> r100, List<Message> r101, String r102, String r103, String r104, JSONObject r105);
}
