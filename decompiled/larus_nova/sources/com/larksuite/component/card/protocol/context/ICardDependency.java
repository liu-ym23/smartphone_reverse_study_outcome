package com.larksuite.component.card.protocol.context;

import android.content.Context;
import android.view.View;
import com.larksuite.component.card.plugin.CardDigestPlugin;
import com.larksuite.component.card.plugin.CardUpdateLocalDataPlugin;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.context.action.CardActionService;
import com.larksuite.component.card.protocol.context.action.CardOpenUrlService;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.photopicker.gallery.callback.OnImageSelectListener;
import com.ss.android.lark.widget.photopicker.gallery.callback.VideoOperateListener;
import com.ss.android.lark.widget.richtext.Image;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 82\u00020\u0001:\u00018J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\fH\u0016J<\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\tH\u0016JO\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u001e2\b\u0010!\u001a\u0004\u0018\u00010\u00142\b\u0010\"\u001a\u0004\u0018\u00010\u001e2\u000e\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0$H\u0016¢\u0006\u0002\u0010&J\b\u0010'\u001a\u00020\u0014H\u0016J\u0018\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0014H\u0016J\u001c\u0010,\u001a\u00020\u00072\b\u0010-\u001a\u0004\u0018\u00010\u001e2\b\u0010.\u001a\u0004\u0018\u00010\u001eH\u0016J \u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u001eH\u0016J\u0010\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u00020\u0007H\u0016¨\u00069"}, d2 = {"Lcom/larksuite/component/card/protocol/context/ICardDependency;", "Ljava/io/Serializable;", "getCardActionService", "Lcom/larksuite/component/card/protocol/context/action/CardActionService;", "getOpenUrlService", "Lcom/larksuite/component/card/protocol/context/action/CardOpenUrlService;", "previewImage", "", "imageView", "Landroid/view/View;", "cardImages", "", "Lcom/ss/android/lark/widget/richtext/Image;", "clickedImageItem", "previewVideo", "cardContext", "Lcom/larksuite/component/card/protocol/CardContext;", "photoItems", "Lcom/ss/android/lark/widget/photopicker/entity/PhotoItem;", "enableDownload", "", "videoOperateListener", "Lcom/ss/android/lark/widget/photopicker/gallery/callback/VideoOperateListener;", "previewFinishListener", "Lcom/ss/android/lark/widget/photopicker/gallery/callback/OnImageSelectListener;", "(Lcom/larksuite/component/card/protocol/CardContext;Ljava/util/List;ZLcom/ss/android/lark/widget/photopicker/gallery/callback/VideoOperateListener;Lcom/ss/android/lark/widget/photopicker/gallery/callback/OnImageSelectListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onLongClicked", "view", "updateCardLocalCache", "cardID", "", "cardVersion", "deltaData", "needPush", "sourceId", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/larksuite/component/card/plugin/CardUpdateLocalDataPlugin$CardUpdateLocalDataResponse;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/larksuite/framework/callback/IGetDataCallback;)V", "canCopy", "onCopySelectText", "copyText", "", "isPartial", CardDigestPlugin.SET_MSG_CARD_SUMMARY, "summary", "translateSummary", "openProfilePage", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "userId", "chatId", "updateStreamingState", "streamingPhase", "Lcom/larksuite/component/card/protocol/context/StreamingState$StreamingPhase;", "reRender", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ICardDependency extends Serializable {
    public static final a Companion = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f283896a = null;

        static {
            f283896a = new a();
        }

        public a() {
        }
    }

    public static final class b {
        public static void a(Context r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "userId");
            Intrinsics.checkNotNullParameter(r102, "chatId");
            ty7.a.a().startContactsProfileActivityByChatterId(r100, r101, r102);
        }
    }

    static {
        Companion = a.f283896a;
    }

    boolean canCopy();

    CardActionService getCardActionService();

    CardOpenUrlService getOpenUrlService();

    void onCopySelectText(CharSequence r100, boolean r101);

    boolean onLongClicked(View r100);

    void openProfilePage(Context r100, String r101, String r102);

    void previewImage(View r100, List<? extends Image> r101, Image r102);

    Object previewVideo(CardContext r100, List<? extends PhotoItem> r101, boolean r102, VideoOperateListener r103, OnImageSelectListener r104, Continuation<? super Unit> r105);

    void reRender();

    void setMsgCardSummary(String r100, String r101);

    void updateCardLocalCache(String r100, String r101, String r102, Boolean r103, String r104, IGetDataCallback<CardUpdateLocalDataPlugin.CardUpdateLocalDataResponse> r105);

    void updateStreamingState(StreamingState.StreamingPhase r100);
}
