package com.ss.android.lark.widget.photo.preview;

import android.os.Bundle;
import com.larksuite.framework.utils.h0;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.widget.photo.preview.callback.OperateListener;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.photopicker.gallery.callback.OnImageSelectListener;
import com.ss.android.lark.widget.photopicker.gallery.callback.OnLoadMoreListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bX\u0018\u0000 \u008b\u00012\u00020\u0001:\u0004\u008b\u0001\u008c\u0001BÍ\u0002\b\u0002\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\t\u0012\u0006\u0010\u001a\u001a\u00020\t\u0012\u0006\u0010\u001b\u001a\u00020\t\u0012\u0006\u0010\u001c\u001a\u00020\t\u0012\u0006\u0010\u001d\u001a\u00020\t\u0012\u0006\u0010\u001e\u001a\u00020\t\u0012\u0006\u0010\u001f\u001a\u00020\t\u0012\u0006\u0010 \u001a\u00020\t\u0012\b\u0010!\u001a\u0004\u0018\u00010\"\u0012\b\u0010#\u001a\u0004\u0018\u00010$\u0012\b\u0010%\u001a\u0004\u0018\u00010&\u0012\u0006\u0010'\u001a\u00020\u0007\u0012\u0014\u0010(\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)\u0018\u00010\u0003\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010-\u001a\u00020\t\u0012\u0006\u0010.\u001a\u00020\t\u0012\b\u0010/\u001a\u0004\u0018\u000100\u0012\b\b\u0002\u00101\u001a\u00020\t¢\u0006\u0004\b2\u00103B\u0011\b\u0012\u0012\u0006\u00104\u001a\u000205¢\u0006\u0004\b2\u00106R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010=\"\u0004\b>\u0010?R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010=\"\u0004\bI\u0010?R\u001a\u0010\u000f\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010=\"\u0004\bK\u0010?R\u001a\u0010\u0010\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010=\"\u0004\bM\u0010?R\u001a\u0010\u0011\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010=\"\u0004\bO\u0010?R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001a\u0010\u0014\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010=\"\u0004\bU\u0010?R\u001a\u0010\u0015\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010=\"\u0004\bW\u0010?R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Q\"\u0004\bY\u0010SR\u001a\u0010\u0017\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010=\"\u0004\b[\u0010?R\u001a\u0010\u0018\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010=\"\u0004\b]\u0010?R\u001a\u0010\u0019\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010=\"\u0004\b_\u0010?R\u001a\u0010\u001a\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010=\"\u0004\ba\u0010?R\u001a\u0010\u001b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010=\"\u0004\bc\u0010?R\u001a\u0010\u001c\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010=\"\u0004\be\u0010?R\u001a\u0010\u001d\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010=\"\u0004\bf\u0010?R\u001a\u0010\u001e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010=\"\u0004\bh\u0010?R\u001a\u0010\u001f\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010=\"\u0004\bj\u0010?R\u001a\u0010 \u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010=\"\u0004\bl\u0010?R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\u001a\u0010'\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010:\"\u0004\bz\u0010<R(\u0010(\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u00108\"\u0004\b|\u0010}R\u001c\u0010+\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010Q\"\u0004\b\u007f\u0010SR\u001e\u0010,\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010Q\"\u0005\b\u0081\u0001\u0010SR\u001b\u0010-\u001a\u00020\tX\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b-\u0010=\"\u0005\b\u0082\u0001\u0010?R\u001c\u0010.\u001a\u00020\tX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010=\"\u0005\b\u0084\u0001\u0010?R \u0010/\u001a\u0004\u0018\u000100X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001c\u00101\u001a\u00020\tX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0089\u0001\u0010=\"\u0005\b\u008a\u0001\u0010?¨\u0006\u008d\u0001"}, d2 = {"Lcom/ss/android/lark/widget/photo/preview/PhotoPagerInitData;", "Ljava/io/Serializable;", "photoItem", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/widget/photopicker/entity/PhotoItem;", "Lkotlin/collections/ArrayList;", "currentItem", "", "isMute", "", "loadMoreListener", "Lcom/ss/android/lark/widget/photopicker/gallery/callback/OnLoadMoreListener;", "operateListener", "Lcom/ss/android/lark/widget/photo/preview/callback/OperateListener;", "showImageOCR", "showFloatMenu", "showSaveButton", "showJumpChatBtn", "jumpChatBtnText", "", "showSaveToDriver", "showForwardButton", "originMergeForwardId", "showTranslationBtn", "showSaveStickerBtn", "showQRCodeBtn", "showEditBtn", "showViewChatImage", "showCopyImageButton", "isSecret", "enableLongClick", "showPhotoIndex", "showPhotoTitleBar", "biz", "Lcom/ss/android/lark/appreciablelib/Biz;", "scene", "Lcom/ss/android/lark/appreciablelib/Scene;", "enterSource", "Lcom/ss/android/lark/widget/photo/preview/EnterSource;", "fromType", "extendList", "Ljava/lang/Class;", "Lcom/ss/android/lark/widget/photo/preview/menu/action/IExtendFuncAction;", "previewId", "msgLinkToken", "isSecure", "autoPlay", "imageSelectListener", "Lcom/ss/android/lark/widget/photopicker/gallery/callback/OnImageSelectListener;", "useBizInterceptors", "<init>", "(Ljava/util/ArrayList;IZLcom/ss/android/lark/widget/photopicker/gallery/callback/OnLoadMoreListener;Lcom/ss/android/lark/widget/photo/preview/callback/OperateListener;ZZZZLjava/lang/String;ZZLjava/lang/String;ZZZZZZZZZZLcom/ss/android/lark/appreciablelib/Biz;Lcom/ss/android/lark/appreciablelib/Scene;Lcom/ss/android/lark/widget/photo/preview/EnterSource;ILjava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;ZZLcom/ss/android/lark/widget/photopicker/gallery/callback/OnImageSelectListener;Z)V", "builder", "Lcom/ss/android/lark/widget/photo/preview/PhotoPagerInitData$Builder;", "(Lcom/ss/android/lark/widget/photo/preview/PhotoPagerInitData$Builder;)V", "getPhotoItem", "()Ljava/util/ArrayList;", "getCurrentItem", "()I", "setCurrentItem", "(I)V", "()Z", "setMute", "(Z)V", "getLoadMoreListener", "()Lcom/ss/android/lark/widget/photopicker/gallery/callback/OnLoadMoreListener;", "setLoadMoreListener", "(Lcom/ss/android/lark/widget/photopicker/gallery/callback/OnLoadMoreListener;)V", "getOperateListener", "()Lcom/ss/android/lark/widget/photo/preview/callback/OperateListener;", "setOperateListener", "(Lcom/ss/android/lark/widget/photo/preview/callback/OperateListener;)V", "getShowImageOCR", "setShowImageOCR", "getShowFloatMenu", "setShowFloatMenu", "getShowSaveButton", "setShowSaveButton", "getShowJumpChatBtn", "setShowJumpChatBtn", "getJumpChatBtnText", "()Ljava/lang/String;", "setJumpChatBtnText", "(Ljava/lang/String;)V", "getShowSaveToDriver", "setShowSaveToDriver", "getShowForwardButton", "setShowForwardButton", "getOriginMergeForwardId", "setOriginMergeForwardId", "getShowTranslationBtn", "setShowTranslationBtn", "getShowSaveStickerBtn", "setShowSaveStickerBtn", "getShowQRCodeBtn", "setShowQRCodeBtn", "getShowEditBtn", "setShowEditBtn", "getShowViewChatImage", "setShowViewChatImage", "getShowCopyImageButton", "setShowCopyImageButton", "setSecret", "getEnableLongClick", "setEnableLongClick", "getShowPhotoIndex", "setShowPhotoIndex", "getShowPhotoTitleBar", "setShowPhotoTitleBar", "getBiz", "()Lcom/ss/android/lark/appreciablelib/Biz;", "setBiz", "(Lcom/ss/android/lark/appreciablelib/Biz;)V", "getScene", "()Lcom/ss/android/lark/appreciablelib/Scene;", "setScene", "(Lcom/ss/android/lark/appreciablelib/Scene;)V", "getEnterSource", "()Lcom/ss/android/lark/widget/photo/preview/EnterSource;", "setEnterSource", "(Lcom/ss/android/lark/widget/photo/preview/EnterSource;)V", "getFromType", "setFromType", "getExtendList", "setExtendList", "(Ljava/util/ArrayList;)V", "getPreviewId", "setPreviewId", "getMsgLinkToken", "setMsgLinkToken", "setSecure", "getAutoPlay", "setAutoPlay", "getImageSelectListener", "()Lcom/ss/android/lark/widget/photopicker/gallery/callback/OnImageSelectListener;", "setImageSelectListener", "(Lcom/ss/android/lark/widget/photopicker/gallery/callback/OnImageSelectListener;)V", "getUseBizInterceptors", "setUseBizInterceptors", "Companion", "Builder", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PhotoPagerInitData implements Serializable {
    public static final b Companion = null;
    public static final String PARAMS_KEY = "KEY_PHOTO_PAGER_INIT_DATA";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient ArrayList<Class<com.ss.android.lark.widget.photo.preview.menu.action.l>> f446550a;
    private boolean autoPlay;
    private Biz biz;
    private int currentItem;
    private boolean enableLongClick;
    private EnterSource enterSource;
    private int fromType;
    private OnImageSelectListener imageSelectListener;
    private boolean isMute;
    private boolean isSecret;
    private boolean isSecure;
    private String jumpChatBtnText;
    private OnLoadMoreListener loadMoreListener;
    private String msgLinkToken;
    private OperateListener operateListener;
    private String originMergeForwardId;
    private final ArrayList<PhotoItem> photoItem;
    private String previewId;
    private Scene scene;
    private boolean showCopyImageButton;
    private boolean showEditBtn;
    private boolean showFloatMenu;
    private boolean showForwardButton;
    private boolean showImageOCR;
    private boolean showJumpChatBtn;
    private boolean showPhotoIndex;
    private boolean showPhotoTitleBar;
    private boolean showQRCodeBtn;
    private boolean showSaveButton;
    private boolean showSaveStickerBtn;
    private boolean showSaveToDriver;
    private boolean showTranslationBtn;
    private boolean showViewChatImage;
    private boolean useBizInterceptors;

    public static final class a {
        public Scene A;
        public int B;
        public ArrayList<Class<com.ss.android.lark.widget.photo.preview.menu.action.l>> C;
        public String D;
        public String E;
        public boolean F;
        public boolean G;
        public boolean H;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList<PhotoItem> f446551a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f446552b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f446553c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public OnLoadMoreListener f446554d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public OperateListener f446555e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public OnImageSelectListener f446556f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f446557g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f446558h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f446559i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f446560j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f446561k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f446562l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f446563m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public String f446564n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f446565o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f446566p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f446567q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f446568r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f446569s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f446570t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f446571u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public boolean f446572v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public boolean f446573w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public boolean f446574x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public EnterSource f446575y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public Biz f446576z;

        public a() {
            this.f446551a = new ArrayList();
            this.f446558h = true;
            this.f446559i = true;
            this.f446560j = true;
            this.f446561k = "";
            this.f446562l = true;
            this.f446567q = true;
            this.f446568r = true;
            this.f446571u = true;
            this.f446575y = EnterSource.Message;
        }

        public final void a(List r100) {
            if (r100 == null) goto L7;
            Iterator r101 = r100.iterator();
        L5:
            if (r101.hasNext() == false) goto L9;
            PhotoItem r102 = (PhotoItem) r101.next();
            r102.resetState();
            this.f446551a.add(r102);
            goto L5
        L9:
            return;
        }
    }

    public static final class b {
        public b() {
        }

        public static PhotoPagerInitData a(Bundle r100) {
            Intrinsics.checkNotNullParameter(r100, "bundle");
            if (r100.containsKey(PhotoPagerInitData.PARAMS_KEY) == false) goto L6;
            Serializable r101 = r100.getSerializable(PhotoPagerInitData.PARAMS_KEY);
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.ss.android.lark.widget.photo.preview.PhotoPagerInitData");
            return (PhotoPagerInitData) r101;
        L6:
            a r102 = new a();
            r102.f446552b = r100.getInt("current_item", 0);
            r102.f446553c = r100.getBoolean("is_mute", false);
            r102.f446554d = (OnLoadMoreListener) r100.getSerializable("load_more_listener");
            r102.f446555e = (OperateListener) r100.getSerializable("operate_listener");
            r102.f446556f = (OnImageSelectListener) r100.getParcelable("image_select_listener");
            r102.f446558h = r100.getBoolean("show_float_menu", true);
            r102.f446557g = r100.getBoolean("show_image_ocr", false);
            if (r100.getBoolean("show_save", true) == true) goto L9;
        L11:
            boolean r103 = false;
        L12:
            r102.f446559i = r103;
            r102.f446560j = r100.getBoolean("show_jump_chat", true);
            String r104 = r100.getString("jump_chat_btn_text");
            String r105 = "";
            if (r104 != null) goto L15;
            r104 = "";
        L15:
            Intrinsics.checkNotNullParameter(r104, "jumpChatBtnText");
            r102.f446561k = r104;
            if (r100.getBoolean("show_save_to_driver", true) == true) goto L18;
        L20:
            boolean r106 = false;
        L21:
            r102.f446562l = r106;
            r102.f446563m = r100.getBoolean("show_show_forward", false);
            r102.f446564n = r100.getString("origin_merge_forward_id", null);
            r102.f446565o = r100.getBoolean("show_translation", false);
            r102.f446567q = r100.getBoolean("show_qr_code", true);
            r102.f446568r = r100.getBoolean("show_edit", true);
            r102.f446570t = r100.getBoolean("is_secret", false);
            r102.f446571u = r100.getBoolean("enable_long_click", true);
            r102.f446573w = r100.getBoolean("show_photo_index_label", false);
            r102.f446574x = r100.getBoolean("show_photo_title_bar", false);
            r102.f446566p = r100.getBoolean("show_save_sticker", false);
            r102.f446569s = r100.getBoolean("show_view_chat_image", false);
            r102.f446572v = r100.getBoolean("show_copy_image", false);
            String r107 = r100.getString("preview_id");
            if (r107 != null) goto L24;
            r107 = "";
        L24:
            r102.D = r107;
            String r108 = r100.getString("msg_link_token");
            if (r108 == null) goto L28;
            r105 = r108;
        L28:
            r102.E = r105;
            r102.f446576z = (Biz) r100.getSerializable("biz");
            r102.A = (Scene) r100.getSerializable("scene");
            EnterSource r109 = (EnterSource) r100.getSerializable(com.bytedance.android.ec.core.event.a.KEY_ENTER_SOURCE);
            if (r109 == null) goto L31;
            r102.f446575y = r109;
        L31:
            r102.B = r100.getInt("from_type", 0);
            r102.F = r100.getBoolean("extra_is_secure", false);
            r102.G = r100.getBoolean("extra_auto_play", false);
            r102.H = r100.getBoolean("extra_biz_interceptors", false);
            if (r100.containsKey("extend_func_list") == false) goto L35;
            Serializable r110 = r100.getSerializable("extend_func_list");
            Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type java.util.ArrayList<java.lang.Class<com.ss.android.lark.widget.photo.preview.menu.action.IExtendFuncAction>>");
            ArrayList<Class<com.ss.android.lark.widget.photo.preview.menu.action.l>> r111 = (ArrayList) r110;
            Intrinsics.checkNotNullParameter(r111, "extendList");
            r102.C = r111;
        L35:
            if (r100.getBoolean("direct_pass_photo_data", false) == false) goto L37;
            Serializable r112 = r100.getSerializable("photos_preview");
            Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type kotlin.collections.List<com.ss.android.lark.widget.photopicker.entity.PhotoItem>");
            List r113 = (List) r112;
        L41:
            r102.a(r113);
            return new PhotoPagerInitData(r102, null);
        L37:
            String r114 = r100.getString("key_photos_preview");
            Object r115 = h0.a.f285998a.a(r114);
            ArrayList r116 = new ArrayList();
            if ((r115 instanceof List) == false) goto L40;
            r116.addAll((List) r115);
        L40:
            r113 = r116;
            goto L41
        L18:
            if (com.ss.android.lark.widget.photopicker.f.a().E() == false) goto L20;
            r106 = true;
            goto L21
        L9:
            if (com.ss.android.lark.widget.photopicker.f.a().F() == true) goto L11;
            r103 = true;
            goto L12
        }
    }

    static {
        Companion = new b();
    }

    public final boolean getAutoPlay() {
        return this.autoPlay;
    }

    public final Biz getBiz() {
        return this.biz;
    }

    public final int getCurrentItem() {
        return this.currentItem;
    }

    public final boolean getEnableLongClick() {
        return this.enableLongClick;
    }

    public final EnterSource getEnterSource() {
        return this.enterSource;
    }

    public final ArrayList<Class<com.ss.android.lark.widget.photo.preview.menu.action.l>> getExtendList() {
        return this.f446550a;
    }

    public final int getFromType() {
        return this.fromType;
    }

    public final OnImageSelectListener getImageSelectListener() {
        return this.imageSelectListener;
    }

    public final String getJumpChatBtnText() {
        return this.jumpChatBtnText;
    }

    public final OnLoadMoreListener getLoadMoreListener() {
        return this.loadMoreListener;
    }

    public final String getMsgLinkToken() {
        return this.msgLinkToken;
    }

    public final OperateListener getOperateListener() {
        return this.operateListener;
    }

    public final String getOriginMergeForwardId() {
        return this.originMergeForwardId;
    }

    public final ArrayList<PhotoItem> getPhotoItem() {
        return this.photoItem;
    }

    public final String getPreviewId() {
        return this.previewId;
    }

    public final Scene getScene() {
        return this.scene;
    }

    public final boolean getShowCopyImageButton() {
        return this.showCopyImageButton;
    }

    public final boolean getShowEditBtn() {
        return this.showEditBtn;
    }

    public final boolean getShowFloatMenu() {
        return this.showFloatMenu;
    }

    public final boolean getShowForwardButton() {
        return this.showForwardButton;
    }

    public final boolean getShowImageOCR() {
        return this.showImageOCR;
    }

    public final boolean getShowJumpChatBtn() {
        return this.showJumpChatBtn;
    }

    public final boolean getShowPhotoIndex() {
        return this.showPhotoIndex;
    }

    public final boolean getShowPhotoTitleBar() {
        return this.showPhotoTitleBar;
    }

    public final boolean getShowQRCodeBtn() {
        return this.showQRCodeBtn;
    }

    public final boolean getShowSaveButton() {
        return this.showSaveButton;
    }

    public final boolean getShowSaveStickerBtn() {
        return this.showSaveStickerBtn;
    }

    public final boolean getShowSaveToDriver() {
        return this.showSaveToDriver;
    }

    public final boolean getShowTranslationBtn() {
        return this.showTranslationBtn;
    }

    public final boolean getShowViewChatImage() {
        return this.showViewChatImage;
    }

    public final boolean getUseBizInterceptors() {
        return this.useBizInterceptors;
    }

    public final boolean isMute() {
        return this.isMute;
    }

    public final boolean isSecret() {
        return this.isSecret;
    }

    public final boolean isSecure() {
        return this.isSecure;
    }

    public final void setAutoPlay(boolean r100) {
        this.autoPlay = r100;
    }

    public final void setBiz(Biz r100) {
        this.biz = r100;
    }

    public final void setCurrentItem(int r100) {
        this.currentItem = r100;
    }

    public final void setEnableLongClick(boolean r100) {
        this.enableLongClick = r100;
    }

    public final void setEnterSource(EnterSource r100) {
        this.enterSource = r100;
    }

    public final void setExtendList(ArrayList<Class<com.ss.android.lark.widget.photo.preview.menu.action.l>> r100) {
        this.f446550a = r100;
    }

    public final void setFromType(int r100) {
        this.fromType = r100;
    }

    public final void setImageSelectListener(OnImageSelectListener r100) {
        this.imageSelectListener = r100;
    }

    public final void setJumpChatBtnText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.jumpChatBtnText = r100;
    }

    public final void setLoadMoreListener(OnLoadMoreListener r100) {
        this.loadMoreListener = r100;
    }

    public final void setMsgLinkToken(String r100) {
        this.msgLinkToken = r100;
    }

    public final void setMute(boolean r100) {
        this.isMute = r100;
    }

    public final void setOperateListener(OperateListener r100) {
        this.operateListener = r100;
    }

    public final void setOriginMergeForwardId(String r100) {
        this.originMergeForwardId = r100;
    }

    public final void setPreviewId(String r100) {
        this.previewId = r100;
    }

    public final void setScene(Scene r100) {
        this.scene = r100;
    }

    public final void setSecret(boolean r100) {
        this.isSecret = r100;
    }

    public final void setSecure(boolean r100) {
        this.isSecure = r100;
    }

    public final void setShowCopyImageButton(boolean r100) {
        this.showCopyImageButton = r100;
    }

    public final void setShowEditBtn(boolean r100) {
        this.showEditBtn = r100;
    }

    public final void setShowFloatMenu(boolean r100) {
        this.showFloatMenu = r100;
    }

    public final void setShowForwardButton(boolean r100) {
        this.showForwardButton = r100;
    }

    public final void setShowImageOCR(boolean r100) {
        this.showImageOCR = r100;
    }

    public final void setShowJumpChatBtn(boolean r100) {
        this.showJumpChatBtn = r100;
    }

    public final void setShowPhotoIndex(boolean r100) {
        this.showPhotoIndex = r100;
    }

    public final void setShowPhotoTitleBar(boolean r100) {
        this.showPhotoTitleBar = r100;
    }

    public final void setShowQRCodeBtn(boolean r100) {
        this.showQRCodeBtn = r100;
    }

    public final void setShowSaveButton(boolean r100) {
        this.showSaveButton = r100;
    }

    public final void setShowSaveStickerBtn(boolean r100) {
        this.showSaveStickerBtn = r100;
    }

    public final void setShowSaveToDriver(boolean r100) {
        this.showSaveToDriver = r100;
    }

    public final void setShowTranslationBtn(boolean r100) {
        this.showTranslationBtn = r100;
    }

    public final void setShowViewChatImage(boolean r100) {
        this.showViewChatImage = r100;
    }

    public final void setUseBizInterceptors(boolean r100) {
        this.useBizInterceptors = r100;
    }

    public PhotoPagerInitData(a r310, DefaultConstructorMarker r311) {
        this(r310.f446551a, r310.f446552b, r310.f446553c, r310.f446554d, r310.f446555e, r310.f446557g, r310.f446558h, r310.f446559i, r310.f446560j, r310.f446561k, r310.f446562l, r310.f446563m, r310.f446564n, r310.f446565o, r310.f446566p, r310.f446567q, r310.f446568r, r310.f446569s, r310.f446572v, r310.f446570t, r310.f446571u, r310.f446573w, r310.f446574x, r310.f446576z, r310.A, r310.f446575y, r310.B, r310.C, r310.D, r310.E, r310.F, r310.G, r310.f446556f, r310.H);
    }

    public PhotoPagerInitData(ArrayList<PhotoItem> r100, int r101, boolean r102, OnLoadMoreListener r103, OperateListener r104, boolean r105, boolean r106, boolean r110, boolean r111, String r112, boolean r113, boolean r114, String r115, boolean r116, boolean r117, boolean r118, boolean r119, boolean r210, boolean r211, boolean r212, boolean r213, boolean r214, boolean r215, Biz r216, Scene r217, EnterSource r218, int r219, ArrayList<Class<com.ss.android.lark.widget.photo.preview.menu.action.l>> r310, String r311, String r312, boolean r313, boolean r314, OnImageSelectListener r315, boolean r316) {
        this.photoItem = r100;
        this.currentItem = r101;
        this.isMute = r102;
        this.loadMoreListener = r103;
        this.operateListener = r104;
        this.showImageOCR = r105;
        this.showFloatMenu = r106;
        this.showSaveButton = r110;
        this.showJumpChatBtn = r111;
        this.jumpChatBtnText = r112;
        this.showSaveToDriver = r113;
        this.showForwardButton = r114;
        this.originMergeForwardId = r115;
        this.showTranslationBtn = r116;
        this.showSaveStickerBtn = r117;
        this.showQRCodeBtn = r118;
        this.showEditBtn = r119;
        this.showViewChatImage = r210;
        this.showCopyImageButton = r211;
        this.isSecret = r212;
        this.enableLongClick = r213;
        this.showPhotoIndex = r214;
        this.showPhotoTitleBar = r215;
        this.biz = r216;
        this.scene = r217;
        this.enterSource = r218;
        this.fromType = r219;
        this.f446550a = r310;
        this.previewId = r311;
        this.msgLinkToken = r312;
        this.isSecure = r313;
        this.autoPlay = r314;
        this.imageSelectListener = r315;
        this.useBizInterceptors = r316;
    }

    public /* synthetic */ PhotoPagerInitData(ArrayList r310, int r311, boolean r312, OnLoadMoreListener r410, OperateListener r411, boolean r412, boolean r413, boolean r414, boolean r415, String r416, boolean r417, boolean r418, String r419, boolean r510, boolean r511, boolean r512, boolean r513, boolean r514, boolean r515, boolean r516, boolean r517, boolean r518, boolean r519, Biz r610, Scene r611, EnterSource r612, int r613, ArrayList r614, String r615, String r616, boolean r617, boolean r618, OnImageSelectListener r619, boolean r710, int r711, int r712, DefaultConstructorMarker r713) {
        if ((r711 & 512) == 0) goto L5;
        String r110 = "";
    L7:
        if ((r712 & 2) == 0) goto L9;
        boolean r313 = false;
    L10:
        this(r310, r311, r312, r410, r411, r412, r413, r414, r415, r110, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r313);
        return;
    L9:
        r313 = r710;
        goto L10
    L5:
        r110 = r416;
        goto L7
    }
}
