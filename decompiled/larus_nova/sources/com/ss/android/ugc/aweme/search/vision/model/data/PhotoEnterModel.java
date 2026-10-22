package com.ss.android.ugc.aweme.search.vision.model.data;

import android.graphics.Bitmap;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.search.model.SearchConfig;
import com.ss.android.ugc.aweme.search.vision.ScanPageParams;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\\\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 Ú\u00012\u00020\u0001:\u0002Ú\u0001B\t¢\u0006\u0006\bØ\u0001\u0010Ù\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR$\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR$\u0010#\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR$\u0010&\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR$\u0010)\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR$\u0010,\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\bR$\u0010/\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0004\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\bR$\u00102\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\u0004\u001a\u0004\b3\u0010\u0006\"\u0004\b4\u0010\bR\"\u00106\u001a\u0002058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010<\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010\u0004\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\bR$\u0010?\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010\u0004\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\bR$\u0010B\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010\u0004\u001a\u0004\bC\u0010\u0006\"\u0004\bD\u0010\bR$\u0010E\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bE\u0010\u0004\u001a\u0004\bF\u0010\u0006\"\u0004\bG\u0010\bR$\u0010H\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bH\u0010\u0004\u001a\u0004\bI\u0010\u0006\"\u0004\bJ\u0010\bR$\u0010K\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bK\u0010\u0004\u001a\u0004\bL\u0010\u0006\"\u0004\bM\u0010\bR\"\u0010O\u001a\u00020N8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR$\u0010U\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bU\u0010\u0004\u001a\u0004\bV\u0010\u0006\"\u0004\bW\u0010\bR$\u0010X\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bX\u0010\u0004\u001a\u0004\bY\u0010\u0006\"\u0004\bZ\u0010\bR$\u0010[\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b[\u0010\u0004\u001a\u0004\b\\\u0010\u0006\"\u0004\b]\u0010\bR$\u0010^\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b^\u0010\u0004\u001a\u0004\b_\u0010\u0006\"\u0004\b`\u0010\bR$\u0010a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\ba\u0010\u0004\u001a\u0004\bb\u0010\u0006\"\u0004\bc\u0010\bR$\u0010e\u001a\u0004\u0018\u00010d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR$\u0010k\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bk\u0010\u0004\u001a\u0004\bl\u0010\u0006\"\u0004\bm\u0010\bR$\u0010n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bn\u0010\u0004\u001a\u0004\bo\u0010\u0006\"\u0004\bp\u0010\bR$\u0010q\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bq\u0010\u0004\u001a\u0004\br\u0010\u0006\"\u0004\bs\u0010\bR*\u0010u\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bu\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR%\u0010{\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0087\u000e¢\u0006\u0013\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R(\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0081\u0001\u0010\u0004\u001a\u0005\b\u0082\u0001\u0010\u0006\"\u0005\b\u0083\u0001\u0010\bR.\u0010\u0084\u0001\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010t8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0084\u0001\u0010v\u001a\u0005\b\u0085\u0001\u0010x\"\u0005\b\u0086\u0001\u0010zR.\u0010\u0087\u0001\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010t8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0087\u0001\u0010v\u001a\u0005\b\u0088\u0001\u0010x\"\u0005\b\u0089\u0001\u0010zR(\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u008a\u0001\u0010\u0004\u001a\u0005\b\u008b\u0001\u0010\u0006\"\u0005\b\u008c\u0001\u0010\bR(\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u008d\u0001\u0010\u0004\u001a\u0005\b\u008e\u0001\u0010\u0006\"\u0005\b\u008f\u0001\u0010\bR&\u0010\u0090\u0001\u001a\u00020N8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0090\u0001\u0010P\u001a\u0005\b\u0091\u0001\u0010R\"\u0005\b\u0092\u0001\u0010TR&\u0010\u0093\u0001\u001a\u00020N8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0093\u0001\u0010P\u001a\u0005\b\u0094\u0001\u0010R\"\u0005\b\u0095\u0001\u0010TR(\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0096\u0001\u0010\u0004\u001a\u0005\b\u0097\u0001\u0010\u0006\"\u0005\b\u0098\u0001\u0010\bR)\u0010\u0099\u0001\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0005\b\u0099\u0001\u0010|\u001a\u0005\b\u009a\u0001\u0010~\"\u0006\b\u009b\u0001\u0010\u0080\u0001R(\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u009c\u0001\u0010\u0004\u001a\u0005\b\u009d\u0001\u0010\u0006\"\u0005\b\u009e\u0001\u0010\bR&\u0010\u009f\u0001\u001a\u00020N8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u009f\u0001\u0010P\u001a\u0005\b \u0001\u0010R\"\u0005\b¡\u0001\u0010TR&\u0010¢\u0001\u001a\u00020N8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¢\u0001\u0010P\u001a\u0005\b£\u0001\u0010R\"\u0005\b¤\u0001\u0010TR&\u0010¥\u0001\u001a\u00020N8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¥\u0001\u0010P\u001a\u0005\b¦\u0001\u0010R\"\u0005\b§\u0001\u0010TR(\u0010¨\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¨\u0001\u0010\u0004\u001a\u0005\b©\u0001\u0010\u0006\"\u0005\bª\u0001\u0010\bR(\u0010«\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b«\u0001\u0010\u0004\u001a\u0005\b¬\u0001\u0010\u0006\"\u0005\b\u00ad\u0001\u0010\bR&\u0010®\u0001\u001a\u00020N8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b®\u0001\u0010P\u001a\u0005\b¯\u0001\u0010R\"\u0005\b°\u0001\u0010TR)\u0010±\u0001\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0005\b±\u0001\u0010|\u001a\u0005\b²\u0001\u0010~\"\u0006\b³\u0001\u0010\u0080\u0001R(\u0010´\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b´\u0001\u0010\u0004\u001a\u0005\bµ\u0001\u0010\u0006\"\u0005\b¶\u0001\u0010\bR&\u0010·\u0001\u001a\u00020N8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b·\u0001\u0010P\u001a\u0005\b¸\u0001\u0010R\"\u0005\b¹\u0001\u0010TR&\u0010º\u0001\u001a\u0002058\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bº\u0001\u00107\u001a\u0005\b»\u0001\u00109\"\u0005\b¼\u0001\u0010;R(\u0010½\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b½\u0001\u0010\u0004\u001a\u0005\b¾\u0001\u0010\u0006\"\u0005\b¿\u0001\u0010\bR(\u0010À\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÀ\u0001\u0010\u0004\u001a\u0005\bÁ\u0001\u0010\u0006\"\u0005\bÂ\u0001\u0010\bR(\u0010Ã\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÃ\u0001\u0010\u0004\u001a\u0005\bÄ\u0001\u0010\u0006\"\u0005\bÅ\u0001\u0010\bR(\u0010Æ\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÆ\u0001\u0010\u0004\u001a\u0005\bÇ\u0001\u0010\u0006\"\u0005\bÈ\u0001\u0010\bR&\u0010É\u0001\u001a\u00020N8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÉ\u0001\u0010P\u001a\u0005\bÊ\u0001\u0010R\"\u0005\bË\u0001\u0010TR&\u0010Ì\u0001\u001a\u00020N8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÌ\u0001\u0010P\u001a\u0005\bÌ\u0001\u0010R\"\u0005\bÍ\u0001\u0010TR&\u0010Î\u0001\u001a\u0002058\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÎ\u0001\u00107\u001a\u0005\bÏ\u0001\u00109\"\u0005\bÐ\u0001\u0010;R,\u0010Ò\u0001\u001a\u0005\u0018\u00010Ñ\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bÒ\u0001\u0010Ó\u0001\u001a\u0006\bÔ\u0001\u0010Õ\u0001\"\u0006\bÖ\u0001\u0010×\u0001¨\u0006Û\u0001"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/model/data/PhotoEnterModel;", "Ljava/io/Serializable;", "", "localFilePath", "Ljava/lang/String;", "getLocalFilePath", "()Ljava/lang/String;", "setLocalFilePath", "(Ljava/lang/String;)V", "Landroid/graphics/Bitmap;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/graphics/Bitmap;", "getSearchBitmap", "()Landroid/graphics/Bitmap;", "setSearchBitmap", "(Landroid/graphics/Bitmap;)V", "searchBitmap", "enterMethod", "getEnterMethod", "setEnterMethod", "enterFrom", "getEnterFrom", "setEnterFrom", "searchEnterFrom", "getSearchEnterFrom", "setSearchEnterFrom", "enterFromSecond", "getEnterFromSecond", "setEnterFromSecond", "enterFromThird", "getEnterFromThird", "setEnterFromThird", "typeDetail", "getTypeDetail", "setTypeDetail", "groupId", "getGroupId", "setGroupId", "authorId", "getAuthorId", "setAuthorId", "roomId", "getRoomId", "setRoomId", "anchorId", "getAnchorId", "setAnchorId", "searchType", "getSearchType", "setSearchType", "awemeId", "getAwemeId", "setAwemeId", "", "videoPlayTime", "I", "getVideoPlayTime", "()I", "setVideoPlayTime", "(I)V", "productId", "getProductId", "setProductId", "searchChannel", "getSearchChannel", "setSearchChannel", "searchImageUrl", "getSearchImageUrl", "setSearchImageUrl", "shopId", "getShopId", "setShopId", "productName", "getProductName", "setProductName", "categoryId", "getCategoryId", "setCategoryId", "", "noCropImagesCard", "Z", "getNoCropImagesCard", "()Z", "setNoCropImagesCard", "(Z)V", "searchEventSearchType", "getSearchEventSearchType", "setSearchEventSearchType", "requestId", "getRequestId", "setRequestId", a.KEY_CHANNEL_ID, "getChnid", "setChnid", "extraTrackParams", "getExtraTrackParams", "setExtraTrackParams", "searchEntrance", "getSearchEntrance", "setSearchEntrance", "Lcom/ss/android/ugc/aweme/search/vision/ScanPageParams;", "scanPageParams", "Lcom/ss/android/ugc/aweme/search/vision/ScanPageParams;", "getScanPageParams", "()Lcom/ss/android/ugc/aweme/search/vision/ScanPageParams;", "setScanPageParams", "(Lcom/ss/android/ugc/aweme/search/vision/ScanPageParams;)V", "extra", "getExtra", "setExtra", "clientExtra", "getClientExtra", "setClientExtra", "clientEngineExtra", "getClientEngineExtra", "setClientEngineExtra", "", "tabNameList", "Ljava/util/List;", "getTabNameList", "()Ljava/util/List;", "setTabNameList", "(Ljava/util/List;)V", "productPrice", "Ljava/lang/Integer;", "getProductPrice", "()Ljava/lang/Integer;", "setProductPrice", "(Ljava/lang/Integer;)V", "federationInfo", "getFederationInfo", "setFederationInfo", "searchImageUrlList", "getSearchImageUrlList", "setSearchImageUrlList", "productIdList", "getProductIdList", "setProductIdList", "videoGuideMall", "getVideoGuideMall", "setVideoGuideMall", "transEventExtra", "getTransEventExtra", "setTransEventExtra", "needSendCloseMessage", "getNeedSendCloseMessage", "setNeedSendCloseMessage", "startLiveWindow", "getStartLiveWindow", "setStartLiveWindow", "sourceBtmToken", "getSourceBtmToken", "setSourceBtmToken", "itemPlayTime", "getItemPlayTime", "setItemPlayTime", "skuId", "getSkuId", "setSkuId", "forbidBackgroundAnim", "getForbidBackgroundAnim", "setForbidBackgroundAnim", "forbidFirstEnterAnim", "getForbidFirstEnterAnim", "setForbidFirstEnterAnim", "showEnterToast", "getShowEnterToast", "setShowEnterToast", "ecomSceneId", "getEcomSceneId", "setEcomSceneId", "lynxExtra", "getLynxExtra", "setLynxExtra", "showScreenShotPanel", "getShowScreenShotPanel", "setShowScreenShotPanel", "specialInteractionType", "getSpecialInteractionType", "setSpecialInteractionType", "clientParams", "getClientParams", "setClientParams", "enablePrefetch", "getEnablePrefetch", "setEnablePrefetch", "enableImageMemoryStorage", "getEnableImageMemoryStorage", "setEnableImageMemoryStorage", "shotFilePath", "getShotFilePath", "setShotFilePath", "deliverySessionId", "getDeliverySessionId", "setDeliverySessionId", "keyword", "getKeyword", "setKeyword", "imageUri", "getImageUri", "setImageUri", "useNewDecoration", "getUseNewDecoration", "setUseNewDecoration", "isSplitMode", "setSplitMode", "splitWidthDp", "getSplitWidthDp", "setSplitWidthDp", "Lcom/ss/android/ugc/aweme/search/model/SearchConfig;", "searchConfig", "Lcom/ss/android/ugc/aweme/search/model/SearchConfig;", "getSearchConfig", "()Lcom/ss/android/ugc/aweme/search/model/SearchConfig;", "setSearchConfig", "(Lcom/ss/android/ugc/aweme/search/model/SearchConfig;)V", "<init>", "()V", "Companion", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PhotoEnterModel implements Serializable {
    public static final String CLIENT_PARAMS = "client_params";
    public static final Companion Companion = null;
    public static final String DETECTION = "detection";
    public static final String DETECTION_IMAGE = "detection_image";
    public static final String DETECTION_INDEX = "detection_index";
    public static final String ENABLE_IMAGE_MEMORY_STORAGE = "enable_image_memory_storage";
    public static final String KEYWORD = "keyword";
    public static final String SEARCH_IMAGE_URI = "search_image_uri";
    public static final String SEARCH_IMAGE_URL = "search_image_url";
    public static final String SOURCE_BTM_TOKEN = "source_btm_token";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Bitmap f453598a;

    @SerializedName("anchor_id")
    private String anchorId;

    @SerializedName("author_id")
    private String authorId;

    @SerializedName(SimilarProductParam.AWEME_ID)
    private String awemeId;

    @SerializedName("category_id")
    private String categoryId;

    @SerializedName(a.KEY_CHANNEL_ID)
    private String chnid;

    @SerializedName("client_engine_extra")
    private String clientEngineExtra;

    @SerializedName("client_extra")
    private String clientExtra;

    @SerializedName("client_params")
    private String clientParams;

    @SerializedName("delivery_session_id")
    private String deliverySessionId;

    @SerializedName("ecom_scene_id")
    private String ecomSceneId;

    @SerializedName(ENABLE_IMAGE_MEMORY_STORAGE)
    private int enableImageMemoryStorage;

    @SerializedName("enable_prefetch")
    private boolean enablePrefetch;

    @SerializedName("enter_from")
    private String enterFrom;

    @SerializedName(ECFindSimilarConfig.ENTER_FROM_SECOND)
    private String enterFromSecond;

    @SerializedName("enter_from_third")
    private String enterFromThird;

    @SerializedName("enter_method")
    private String enterMethod;

    @SerializedName("extra")
    private String extra;

    @SerializedName(ECFindSimilarConfig.SEARCH_PASSTHROUGH_PARAMS)
    private String extraTrackParams;

    @SerializedName("federation_info")
    private String federationInfo;

    @SerializedName("forbid_background_anim")
    private boolean forbidBackgroundAnim;

    @SerializedName("forbid_first_enter_anim")
    private boolean forbidFirstEnterAnim;

    @SerializedName("group_id")
    private String groupId;

    @SerializedName(SEARCH_IMAGE_URI)
    private String imageUri;

    @SerializedName("is_split_mode")
    private boolean isSplitMode;

    @SerializedName("item_play_time")
    private Integer itemPlayTime;

    @SerializedName("keyword")
    private String keyword;

    @SerializedName("file_path")
    private String localFilePath;

    @SerializedName("lynx_extra")
    private String lynxExtra;

    @SerializedName("need_send_close_message")
    private boolean needSendCloseMessage;

    @SerializedName("no_crop_images_card")
    private boolean noCropImagesCard;

    @SerializedName("product_id")
    private String productId;

    @SerializedName("product_id_list")
    private List<String> productIdList;

    @SerializedName("product_name")
    private String productName;

    @SerializedName("start_live_window")
    private Integer productPrice;

    @SerializedName("request_id")
    private String requestId;

    @SerializedName("room_id")
    private String roomId;

    @SerializedName(ECFindSimilarConfig.SEARCH_SCAN_PARAMS)
    private ScanPageParams scanPageParams;

    @SerializedName("search_channel")
    private String searchChannel;

    @SerializedName("search_config")
    private SearchConfig searchConfig;

    @SerializedName("enter_from")
    private String searchEnterFrom;

    @SerializedName("search_entrance")
    private String searchEntrance;

    @SerializedName("search_type")
    private String searchEventSearchType;

    @SerializedName("search_image_url")
    private String searchImageUrl;

    @SerializedName("search_image_url_list")
    private List<String> searchImageUrlList;

    @SerializedName("search_type")
    private String searchType;

    @SerializedName(a.KEY_SHOP_ID)
    private String shopId;

    @SerializedName("shot_file_path")
    private String shotFilePath;

    @SerializedName("show_enter_toast")
    private boolean showEnterToast;

    @SerializedName("show_screen_shot_panel")
    private boolean showScreenShotPanel;

    @SerializedName(a.KEY_SKU_ID)
    private String skuId;

    @SerializedName(SOURCE_BTM_TOKEN)
    private String sourceBtmToken;

    @SerializedName("special_interaction_type")
    private Integer specialInteractionType;

    @SerializedName("split_width_dp")
    private int splitWidthDp;

    @SerializedName("start_live_window")
    private boolean startLiveWindow;

    @SerializedName(a.KEY_TAB_NAME)
    private List<String> tabNameList;

    @SerializedName("trans_event_extra")
    private String transEventExtra;

    @SerializedName("photo_search_type_detail")
    private String typeDetail;
    private boolean useNewDecoration;

    @SerializedName("video_guide_mall")
    private String videoGuideMall;

    @SerializedName("video_play_time")
    private int videoPlayTime;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/model/data/PhotoEnterModel$Companion;", "", "()V", "CLIENT_PARAMS", "", "DETECTION", "DETECTION_IMAGE", "DETECTION_INDEX", "ENABLE_IMAGE_MEMORY_STORAGE", "KEYWORD", "SEARCH_IMAGE_URI", "SEARCH_IMAGE_URL", "SOURCE_BTM_TOKEN", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        Companion = new Companion(0);
    }

    public PhotoEnterModel() {
        this.videoPlayTime = -1;
        this.splitWidthDp = -1;
    }

    public final String getAnchorId() {
        return this.anchorId;
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final String getAwemeId() {
        return this.awemeId;
    }

    public final String getCategoryId() {
        return this.categoryId;
    }

    public final String getChnid() {
        return this.chnid;
    }

    public final String getClientEngineExtra() {
        return this.clientEngineExtra;
    }

    public final String getClientExtra() {
        return this.clientExtra;
    }

    public final String getClientParams() {
        return this.clientParams;
    }

    public final String getDeliverySessionId() {
        return this.deliverySessionId;
    }

    public final String getEcomSceneId() {
        return this.ecomSceneId;
    }

    public final int getEnableImageMemoryStorage() {
        return this.enableImageMemoryStorage;
    }

    public final boolean getEnablePrefetch() {
        return this.enablePrefetch;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEnterFromSecond() {
        return this.enterFromSecond;
    }

    public final String getEnterFromThird() {
        return this.enterFromThird;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final String getExtraTrackParams() {
        return this.extraTrackParams;
    }

    public final String getFederationInfo() {
        return this.federationInfo;
    }

    public final boolean getForbidBackgroundAnim() {
        return this.forbidBackgroundAnim;
    }

    public final boolean getForbidFirstEnterAnim() {
        return this.forbidFirstEnterAnim;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final String getImageUri() {
        return this.imageUri;
    }

    public final Integer getItemPlayTime() {
        return this.itemPlayTime;
    }

    public final String getKeyword() {
        return this.keyword;
    }

    public final String getLocalFilePath() {
        return this.localFilePath;
    }

    public final String getLynxExtra() {
        return this.lynxExtra;
    }

    public final boolean getNeedSendCloseMessage() {
        return this.needSendCloseMessage;
    }

    public final boolean getNoCropImagesCard() {
        return this.noCropImagesCard;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final List<String> getProductIdList() {
        return this.productIdList;
    }

    public final String getProductName() {
        return this.productName;
    }

    public final Integer getProductPrice() {
        return this.productPrice;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final ScanPageParams getScanPageParams() {
        return this.scanPageParams;
    }

    public final Bitmap getSearchBitmap() {
        return this.f453598a;
    }

    public final String getSearchChannel() {
        return this.searchChannel;
    }

    public final SearchConfig getSearchConfig() {
        return this.searchConfig;
    }

    public final String getSearchEnterFrom() {
        return this.searchEnterFrom;
    }

    public final String getSearchEntrance() {
        return this.searchEntrance;
    }

    public final String getSearchEventSearchType() {
        return this.searchEventSearchType;
    }

    public final String getSearchImageUrl() {
        return this.searchImageUrl;
    }

    public final List<String> getSearchImageUrlList() {
        return this.searchImageUrlList;
    }

    public final String getSearchType() {
        return this.searchType;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final String getShotFilePath() {
        return this.shotFilePath;
    }

    public final boolean getShowEnterToast() {
        return this.showEnterToast;
    }

    public final boolean getShowScreenShotPanel() {
        return this.showScreenShotPanel;
    }

    public final String getSkuId() {
        return this.skuId;
    }

    public final String getSourceBtmToken() {
        return this.sourceBtmToken;
    }

    public final Integer getSpecialInteractionType() {
        return this.specialInteractionType;
    }

    public final int getSplitWidthDp() {
        return this.splitWidthDp;
    }

    public final boolean getStartLiveWindow() {
        return this.startLiveWindow;
    }

    public final List<String> getTabNameList() {
        return this.tabNameList;
    }

    public final String getTransEventExtra() {
        return this.transEventExtra;
    }

    public final String getTypeDetail() {
        return this.typeDetail;
    }

    public final boolean getUseNewDecoration() {
        return this.useNewDecoration;
    }

    public final String getVideoGuideMall() {
        return this.videoGuideMall;
    }

    public final int getVideoPlayTime() {
        return this.videoPlayTime;
    }

    public final boolean isSplitMode() {
        return this.isSplitMode;
    }

    public final void setAnchorId(String r100) {
        this.anchorId = r100;
    }

    public final void setAuthorId(String r100) {
        this.authorId = r100;
    }

    public final void setAwemeId(String r100) {
        this.awemeId = r100;
    }

    public final void setCategoryId(String r100) {
        this.categoryId = r100;
    }

    public final void setChnid(String r100) {
        this.chnid = r100;
    }

    public final void setClientEngineExtra(String r100) {
        this.clientEngineExtra = r100;
    }

    public final void setClientExtra(String r100) {
        this.clientExtra = r100;
    }

    public final void setClientParams(String r100) {
        this.clientParams = r100;
    }

    public final void setDeliverySessionId(String r100) {
        this.deliverySessionId = r100;
    }

    public final void setEcomSceneId(String r100) {
        this.ecomSceneId = r100;
    }

    public final void setEnableImageMemoryStorage(int r100) {
        this.enableImageMemoryStorage = r100;
    }

    public final void setEnablePrefetch(boolean r100) {
        this.enablePrefetch = r100;
    }

    public final void setEnterFrom(String r100) {
        this.enterFrom = r100;
    }

    public final void setEnterFromSecond(String r100) {
        this.enterFromSecond = r100;
    }

    public final void setEnterFromThird(String r100) {
        this.enterFromThird = r100;
    }

    public final void setEnterMethod(String r100) {
        this.enterMethod = r100;
    }

    public final void setExtra(String r100) {
        this.extra = r100;
    }

    public final void setExtraTrackParams(String r100) {
        this.extraTrackParams = r100;
    }

    public final void setFederationInfo(String r100) {
        this.federationInfo = r100;
    }

    public final void setForbidBackgroundAnim(boolean r100) {
        this.forbidBackgroundAnim = r100;
    }

    public final void setForbidFirstEnterAnim(boolean r100) {
        this.forbidFirstEnterAnim = r100;
    }

    public final void setGroupId(String r100) {
        this.groupId = r100;
    }

    public final void setImageUri(String r100) {
        this.imageUri = r100;
    }

    public final void setItemPlayTime(Integer r100) {
        this.itemPlayTime = r100;
    }

    public final void setKeyword(String r100) {
        this.keyword = r100;
    }

    public final void setLocalFilePath(String r100) {
        this.localFilePath = r100;
    }

    public final void setLynxExtra(String r100) {
        this.lynxExtra = r100;
    }

    public final void setNeedSendCloseMessage(boolean r100) {
        this.needSendCloseMessage = r100;
    }

    public final void setNoCropImagesCard(boolean r100) {
        this.noCropImagesCard = r100;
    }

    public final void setProductId(String r100) {
        this.productId = r100;
    }

    public final void setProductIdList(List<String> r100) {
        this.productIdList = r100;
    }

    public final void setProductName(String r100) {
        this.productName = r100;
    }

    public final void setProductPrice(Integer r100) {
        this.productPrice = r100;
    }

    public final void setRequestId(String r100) {
        this.requestId = r100;
    }

    public final void setRoomId(String r100) {
        this.roomId = r100;
    }

    public final void setScanPageParams(ScanPageParams r100) {
        this.scanPageParams = r100;
    }

    public final void setSearchBitmap(Bitmap r100) {
        this.f453598a = r100;
    }

    public final void setSearchChannel(String r100) {
        this.searchChannel = r100;
    }

    public final void setSearchConfig(SearchConfig r100) {
        this.searchConfig = r100;
    }

    public final void setSearchEnterFrom(String r100) {
        this.searchEnterFrom = r100;
    }

    public final void setSearchEntrance(String r100) {
        this.searchEntrance = r100;
    }

    public final void setSearchEventSearchType(String r100) {
        this.searchEventSearchType = r100;
    }

    public final void setSearchImageUrl(String r100) {
        this.searchImageUrl = r100;
    }

    public final void setSearchImageUrlList(List<String> r100) {
        this.searchImageUrlList = r100;
    }

    public final void setSearchType(String r100) {
        this.searchType = r100;
    }

    public final void setShopId(String r100) {
        this.shopId = r100;
    }

    public final void setShotFilePath(String r100) {
        this.shotFilePath = r100;
    }

    public final void setShowEnterToast(boolean r100) {
        this.showEnterToast = r100;
    }

    public final void setShowScreenShotPanel(boolean r100) {
        this.showScreenShotPanel = r100;
    }

    public final void setSkuId(String r100) {
        this.skuId = r100;
    }

    public final void setSourceBtmToken(String r100) {
        this.sourceBtmToken = r100;
    }

    public final void setSpecialInteractionType(Integer r100) {
        this.specialInteractionType = r100;
    }

    public final void setSplitMode(boolean r100) {
        this.isSplitMode = r100;
    }

    public final void setSplitWidthDp(int r100) {
        this.splitWidthDp = r100;
    }

    public final void setStartLiveWindow(boolean r100) {
        this.startLiveWindow = r100;
    }

    public final void setTabNameList(List<String> r100) {
        this.tabNameList = r100;
    }

    public final void setTransEventExtra(String r100) {
        this.transEventExtra = r100;
    }

    public final void setTypeDetail(String r100) {
        this.typeDetail = r100;
    }

    public final void setUseNewDecoration(boolean r100) {
        this.useNewDecoration = r100;
    }

    public final void setVideoGuideMall(String r100) {
        this.videoGuideMall = r100;
    }

    public final void setVideoPlayTime(int r100) {
        this.videoPlayTime = r100;
    }
}
