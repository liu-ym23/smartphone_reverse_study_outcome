package com.ss.android.lark.picker.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.image.entity.b;
import com.ss.android.lark.image.entity.c;
import com.ss.android.lark.search.dto.constant.SearchCommonConstants;
import com.ss.android.lark.search.dto.info.TagContent;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u0005H\u0007R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/picker/base/PickerBaseModuleDependency;", "", "<init>", "()V", "commonModuleDependency", "Lcom/ss/android/lark/picker/base/PickerBaseModuleDependency$IPickerCommonModuleDependency;", "getCommonModuleDependency", "()Lcom/ss/android/lark/picker/base/PickerBaseModuleDependency$IPickerCommonModuleDependency;", "commonModuleDependency$delegate", "Lkotlin/Lazy;", "getDependency", "IPickerCommonModuleDependency", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PickerBaseModuleDependency {
    public static final PickerBaseModuleDependency INSTANCE = null;
    private static final Lazy commonModuleDependency$delegate = null;

    @Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0007H'J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0007H'J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0003H'J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH'J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH'J\u001c\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\u001a\u001a\u00020\u0003H&J\u001c\u0010\u001b\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007H&J$\u0010\u001d\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u00072\u0010\u0010\u001f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010 H'JJ\u0010\"\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010#\u001a\u0004\u0018\u00010\u00072\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020\rH&J\u0012\u0010+\u001a\u00020\r2\b\u0010,\u001a\u0004\u0018\u00010\u0007H&J4\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020\u00072\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020201j\b\u0012\u0004\u0012\u000202`32\b\u00104\u001a\u0004\u0018\u00010\u0007H&J\n\u00105\u001a\u0004\u0018\u000106H&J\u001a\u00107\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u00072\u0006\u00108\u001a\u00020\rH&J\u001a\u00109\u001a\u00020\u00162\b\u0010:\u001a\u0004\u0018\u00010\u00072\u0006\u0010;\u001a\u00020\rH&J\u001c\u0010<\u001a\u00020\u00162\b\u0010=\u001a\u0004\u0018\u00010\u00072\b\u0010>\u001a\u0004\u0018\u00010?H&J\u001a\u0010@\u001a\u00020\u00162\b\u0010:\u001a\u0004\u0018\u00010\u00072\u0006\u0010;\u001a\u00020\rH&J\u001a\u0010A\u001a\u00020\u00032\b\u0010:\u001a\u0004\u0018\u00010\u00072\u0006\u0010B\u001a\u00020\rH&J\u001a\u0010C\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010D\u001a\u0004\u0018\u00010\u0007H&J*\u0010E\u001a\u0004\u0018\u00010'2\u0006\u0010\u0017\u001a\u00020\u00182\u000e\u0010F\u001a\n\u0012\u0004\u0012\u00020H\u0018\u00010G2\u0006\u0010I\u001a\u00020\u0003H&J\u0010\u0010J\u001a\u00020K2\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0010\u0010L\u001a\u00020\u00162\u0006\u0010M\u001a\u00020NH&J2\u0010O\u001a\u00020\u00162\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020S2\u000e\u0010T\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010G2\b\b\u0001\u0010V\u001a\u00020\rH&J4\u0010W\u001a\u00020\u00162\u0006\u0010R\u001a\u00020S2\b\u0010X\u001a\u0004\u0018\u00010Y2\u000e\u0010T\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010G2\b\b\u0001\u0010V\u001a\u00020\rH&J>\u0010Z\u001a\u00020\u00162\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\\\u001a\u00020\r2\u0010\b\u0002\u0010]\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010G2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020^0 H&J\u0012\u0010_\u001a\u00020\u00032\b\u0010`\u001a\u0004\u0018\u00010\u0007H&JD\u0010a\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010b\u001a\u00020\u00072\u0006\u0010c\u001a\u00020\r2\u0006\u0010d\u001a\u00020\r2\u0006\u0010e\u001a\u00020\u00072\b\b\u0002\u0010f\u001a\u00020\rH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004¨\u0006g"}, d2 = {"Lcom/ss/android/lark/picker/base/PickerBaseModuleDependency$IPickerCommonModuleDependency;", "", "isSimpleTenant", "", "()Z", "isCustomer", "getLoginUserTenantId", "", "getLoginUserId", "getNameWithAnotherName", "chatter", "Lcom/ss/android/lark/chat/entity/chatter/Chatter;", "getDocIcon", "", "docType", "fileName", "getWikiIcon", "getFolderIcon", "isShareFolder", "getDocInlineBlueIcon", "getDocInlineGreyIcon", "startContactsProfileActivityByChatterId", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "chatterId", "tryMyAIOnBoarding", "startBotProfileActivityByBotId", "botId", "getChatById", "chatId", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "loadImage", "localPathOrUrl", "imageView", "Landroid/widget/ImageView;", "placeHolder", "Landroid/graphics/drawable/Drawable;", "errorHolder", "imageWidth", "imageHeight", "getUDIconByKey", "key", "findImageCache", "Lcom/ss/android/lark/image/entity/ImageCache;", "scene", "keyOrder", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/image/entity/FindKey;", "Lkotlin/collections/ArrayList;", "originKey", "getCachedLanguageSetting", "Ljava/util/Locale;", "openChat", "msgPosition", "openThread", "threadId", "threadPosition", "peakFeedCard", "feedId", "feedType", "Lcom/ss/android/lark/search/dto/constant/SearchCommonConstants$FeedType;", "openReplyInThread", "isJumpToReplyInThread", "messagePosition", "openSchema", "link", "getOpenedUserStatusDrawable", "userStatusList", "", "Lcom/bytedance/lark/pb/basic/v1/Chatter$ChatterCustomStatus;", "isScale", "makeDynamicRender", "Lcom/ss/android/lark/search/dto/ISearchDynamicRender;", "registerModelBinder", KtvSubElement.CONTAINER, "Lcom/larksuite/component/ui/list/ICompositeComponent;", "addSearchHighLightedTag", "builder", "Landroid/text/SpannableStringBuilder;", "textView", "Landroid/widget/TextView;", "tagList", "Lcom/ss/android/lark/search/dto/info/TagContent;", "highLightColor", "bindHighLightTitle", "title", "", "fetchRecentListPage", "lastLabel", "length", "objTypeList", "Lcom/ss/android/lark/picker/base/RecentListPageResult;", "isSupportDocCover", "type", "loadDocCover", "token", "height", "width", "policy", "cornerRadius", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface IPickerCommonModuleDependency {

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public static final class DefaultImpls {
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ void fetchRecentListPage$default(IPickerCommonModuleDependency r100, String r101, int r102, List r103, IGetDataCallback r104, int r105, Object r106) {
                if (r106 != null) goto L15;
                if ((r105 & 1) == 0) goto L7;
                r101 = null;
            L7:
                if ((r105 & 2) == 0) goto L10;
                r102 = 20;
            L10:
                if ((r105 & 4) == 0) goto L12;
                r103 = null;
            L12:
                r100.fetchRecentListPage(r101, r102, r103, r104);
                return;
            L15:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchRecentListPage");
            }

            public static /* synthetic */ String loadDocCover$default(IPickerCommonModuleDependency r100, Context r110, ImageView r111, String r112, int r113, int r114, String r115, int r116, int r117, Object r118) {
                if (r118 != null) goto L10;
                if ((r117 & 64) == 0) goto L6;
                int r101 = 0;
            L8:
                return r100.loadDocCover(r110, r111, r112, r113, r114, r115, r101);
            L6:
                r101 = r116;
                goto L8
            L10:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadDocCover");
            }
        }

        void addSearchHighLightedTag(SpannableStringBuilder r100, TextView r101, List<TagContent> r102, int r103);

        void bindHighLightTitle(TextView r100, CharSequence r101, List<TagContent> r102, int r103);

        void fetchRecentListPage(String r100, int r101, List<Integer> r102, IGetDataCallback<RecentListPageResult> r103);

        c findImageCache(String r100, ArrayList<b> r101, String r102);

        Locale getCachedLanguageSetting();

        void getChatById(String r100, IGetDataCallback<Chat> r101);

        int getDocIcon(int r100, String r101);

        int getDocInlineBlueIcon(int r100);

        int getDocInlineGreyIcon(int r100);

        int getFolderIcon(boolean r100);

        String getLoginUserId();

        String getLoginUserTenantId();

        String getNameWithAnotherName(Chatter r100);

        Drawable getOpenedUserStatusDrawable(Context r100, List<com.bytedance.lark.pb.basic.v1.Chatter.ChatterCustomStatus> r101, boolean r102);

        int getUDIconByKey(String r100);

        int getWikiIcon(int r100, String r101);

        boolean isCustomer();

        boolean isJumpToReplyInThread(String r100, int r101);

        boolean isSimpleTenant();

        boolean isSupportDocCover(String r100);

        String loadDocCover(Context r100, ImageView r101, String r102, int r103, int r104, String r105, int r106);

        void loadImage(Context r100, String r101, ImageView r102, Drawable r103, Drawable r104, int r105, int r106);

        v3c.c makeDynamicRender(Context r100);

        void openChat(String r100, int r101);

        void openReplyInThread(String r100, int r101);

        void openSchema(Context r100, String r101);

        void openThread(String r100, int r101);

        void peakFeedCard(String r100, SearchCommonConstants.FeedType r101);

        void registerModelBinder(b08.c r100);

        void startBotProfileActivityByBotId(Context r100, String r101);

        void startContactsProfileActivityByChatterId(Context r100, String r101);

        boolean tryMyAIOnBoarding();
    }

    private PickerBaseModuleDependency() {
    }

    static {
        INSTANCE = new PickerBaseModuleDependency();
        commonModuleDependency$delegate = LazyKt.lazy(PickerBaseModuleDependency$commonModuleDependency$2.INSTANCE);
    }

    private final IPickerCommonModuleDependency getCommonModuleDependency() {
        return (IPickerCommonModuleDependency) commonModuleDependency$delegate.getValue();
    }

    @JvmStatic
    public static final IPickerCommonModuleDependency getDependency() {
        IPickerCommonModuleDependency r100 = INSTANCE.getCommonModuleDependency();
        Intrinsics.checkNotNull(r100);
        return r100;
    }
}
