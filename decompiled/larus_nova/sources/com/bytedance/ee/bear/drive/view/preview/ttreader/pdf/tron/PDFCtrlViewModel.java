package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import android.app.Application;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SizeF;
import android.view.MotionEvent;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.streaming.PDFStreamingDownloader;
import com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.structure.ScrollState;
import com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.structure.Structure;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.TitleBarViewModel;
import com.bytedance.ee.drive.mime.DriveLocalMime;
import com.bytedance.ee.plugin.common.ttpdfreader.Bookmark;
import com.bytedance.ee.plugin.common.ttpdfreader.PagePart;
import com.bytedance.ee.plugin.common.ttpdfreader.TTPdfReader;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 z2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001zB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u00105\u001a\u00020\u0018J\b\u00106\u001a\u000207H\u0002J\u0006\u00108\u001a\u00020\u0018J\u0006\u0010!\u001a\u00020\u001eJ\u0006\u00109\u001a\u00020\u001eJ\u0006\u0010:\u001a\u00020;J\u000e\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u001eJ\u000e\u0010?\u001a\u00020=2\u0006\u0010@\u001a\u00020\u001eJ\u0006\u0010A\u001a\u00020+J\u0006\u0010B\u001a\u000207J\u000e\u0010C\u001a\u0002072\u0006\u0010>\u001a\u00020\u001eJ\u0016\u0010D\u001a\u0002072\u0006\u0010>\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020\u001eJ\u000e\u0010F\u001a\u00020%2\u0006\u0010>\u001a\u00020\u001eJ\u000e\u0010G\u001a\u0002072\u0006\u0010G\u001a\u00020%J\u0006\u0010H\u001a\u000207J\u0006\u0010I\u001a\u000207J\u0010\u0010J\u001a\u0002072\b\u0010K\u001a\u0004\u0018\u00010LJ\u0006\u0010M\u001a\u000207J\b\u0010N\u001a\u000207H\u0002J\b\u0010O\u001a\u000207H\u0002J\b\u0010P\u001a\u000207H\u0003J\u0018\u0010Q\u001a\u0002072\b\u0010R\u001a\u0004\u0018\u0001032\u0006\u0010S\u001a\u00020TJ\u000e\u0010U\u001a\u0002072\u0006\u0010V\u001a\u00020-J\u0006\u0010W\u001a\u00020\u0018J\u0006\u0010X\u001a\u000207J\b\u0010Y\u001a\u000207H\u0014J\u0006\u0010Z\u001a\u000207JV\u0010[\u001a\u0002072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\\\u001a\u00020\u0018J\u0010\u0010]\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030^H\u0016J\u0010\u0010_\u001a\u0002072\u0006\u0010`\u001a\u000203H\u0016J\u0012\u0010a\u001a\u0002072\b\u0010`\u001a\u0004\u0018\u000103H\u0016J\b\u0010b\u001a\u000203H\u0016J\u0018\u0010c\u001a\u0002072\u0006\u0010d\u001a\u0002032\u0006\u0010e\u001a\u00020\u0018H\u0016J \u0010f\u001a\u0004\u0018\u00010g2\u0006\u0010>\u001a\u00020\u001e2\u0006\u0010h\u001a\u00020\u001e2\u0006\u0010i\u001a\u00020\u001eJ\u0006\u0010j\u001a\u00020\u0018J\u0006\u0010k\u001a\u00020\u0018J\u0006\u0010l\u001a\u00020\u001eJ<\u0010m\u001a\u0002072\u0006\u0010n\u001a\u0002032\u0006\u0010@\u001a\u00020\u001e2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020q0p2\u0006\u0010r\u001a\u00020\u001e2\u0006\u0010s\u001a\u00020\u00182\u0006\u0010t\u001a\u00020\u0018J\u0016\u0010u\u001a\u0002072\u0006\u0010n\u001a\u0002032\u0006\u0010r\u001a\u00020\u001eJ<\u0010v\u001a\u0002072\u0006\u0010n\u001a\u0002032\u0006\u0010@\u001a\u00020\u001e2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020q0p2\u0006\u0010r\u001a\u00020\u001e2\u0006\u0010s\u001a\u00020\u00182\u0006\u0010t\u001a\u00020\u0018J\u0016\u0010w\u001a\u0002072\u0006\u0010n\u001a\u0002032\u0006\u0010r\u001a\u00020\u001eJ\u000e\u0010x\u001a\u0002072\u0006\u0010n\u001a\u000203J\u0006\u0010y\u001a\u000207R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\u0017¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0019\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u0017¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0019\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0\u0017¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u0017¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006{"}, d2 = {"Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFCtrlViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/structure/ScrollableNavigation;", "Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/structure/Structure;", "<init>", "()V", "pdfReader", "Lcom/bytedance/ee/plugin/common/ttpdfreader/TTPdfReader;", "previewFileModel", "Lcom/bytedance/ee/bear/drive/view/preview/wrapper/PreviewFileModel;", "previewViewModel", "Lcom/bytedance/ee/bear/drive/view/preview/wrapper/PreviewViewModel;", "titleBarViewModel", "Lcom/bytedance/ee/bear/drive/view/preview/wrapper/TitleBarViewModel;", "previewView", "Lcom/bytedance/ee/bear/drive/view/preview/wrapper/IPreviewView;", "clickHelper", "Lcom/bytedance/ee/bear/drive/view/preview/ttreader/TTClickHelper;", "showViewTrackEventCallback", "Lcom/bytedance/ee/bear/drive/view/preview/OnShowViewTrackEventCallback;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "bookLoaded", "Landroidx/lifecycle/MutableLiveData;", "", "getBookLoaded", "()Landroidx/lifecycle/MutableLiveData;", "showThumbnail", "getShowThumbnail", "indicator", "", "getIndicator", "pageCount", "getPageCount", "requestPwd", "getRequestPwd", "positionOffset", "", "getPositionOffset", "scrollState", "Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/structure/ScrollState;", "getScrollState", "pdfPageLoader", "Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/IPDFPageLoader;", "lastClickTime", "", "mShowMenu", "pdfOutline", "Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFOutline;", "structure", "activeBookmarkId", "", "fileErrorReloadTime", "isInit", "_init", "", "isShowMenu", "getCurrentPageIndex", "getRenderView", "Landroid/view/View;", "getPageSizeF", "Landroid/util/SizeF;", "page", "getPageResolution", "pageIndex", "getPageLoader", "toggleThumbnail", "turnToPage", "scrollYOffset", "offset", "getCurrentPageOffset", "scale", "setToFirstPage", "dismissOutline", "setTouchEvent", "ev", "Landroid/view/MotionEvent;", "exitFullscreen", "observeNetState", "observeReader", "readOutline", "openPdf", "password", "userComponentAbility", "Lcom/bytedance/ee/bear/drive/usercomponent/DriveUserComponentAbility;", "updateClickTime", "time", "isStreaming", "refresh", "onCleared", "release", "init", "inVC", "getContent", "Landroidx/lifecycle/LiveData;", "scrollTo", "contentId", "setActive", "getActive", "changeCollapseStatus", faceverify.w.BLOB_ELEM_IMAGE_HASHCODE, "status", "getPageForPresentation", "Lcom/bytedance/ee/plugin/common/ttpdfreader/PagePart;", "w", "h", "isPPT", "isPDF", "findFirstVisiblePage", "markContent", "markId", "contentAreaRates", "", "Landroid/graphics/RectF;", "color", "clickable", "countable", "updateContentMarkColor", "markArea", "updateAreaMarkColor", "removeMark", "removeAllMarks", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PDFCtrlViewModel extends ViewModel implements da5.d<Structure> {
    public static final a Companion = null;
    private static final String TAG = "PDFCtrlViewModel";
    private String activeBookmarkId;
    private final MutableLiveData<Boolean> bookLoaded;
    private com.bytedance.ee.bear.drive.view.preview.ttreader.a clickHelper;
    private int fileErrorReloadTime;
    private final MutableLiveData<Integer> indicator;
    private long lastClickTime;
    private LifecycleOwner lifecycleOwner;
    private boolean mShowMenu;
    private final MutableLiveData<Integer> pageCount;
    private volatile j0 pdfOutline;
    private com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.a pdfPageLoader;
    private TTPdfReader pdfReader;
    private final MutableLiveData<Float> positionOffset;
    private com.bytedance.ee.bear.drive.view.preview.wrapper.z previewFileModel;
    private com.bytedance.ee.bear.drive.view.preview.wrapper.m previewView;
    private PreviewViewModel previewViewModel;
    private final MutableLiveData<Integer> requestPwd;
    private final MutableLiveData<ScrollState> scrollState;
    private final MutableLiveData<Boolean> showThumbnail;
    private c95.c showViewTrackEventCallback;
    private final MutableLiveData<Structure> structure;
    private TitleBarViewModel titleBarViewModel;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f225248a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PDFCtrlViewModel f225249b;

        public b(Ref.BooleanRef r100, PDFCtrlViewModel r101) {
            this.f225248a = r100;
            this.f225249b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            Ref.BooleanRef r102 = this.f225248a;
            if (r102.element == false) goto L6;
            r102.element = false;
            return;
        L6:
            if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L10;
            this.f225249b.refresh();
            return;
        }
    }

    public static final class c implements TTPdfReader.Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PDFCtrlViewModel f225250a;

        public static final class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ PDFCtrlViewModel f225251a;

            public a(PDFCtrlViewModel r100) {
                this.f225251a = r100;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                tt5.a.h(PDFCtrlViewModel.TAG, "banner click retry");
                this.f225251a.refresh();
            }
        }

        public static final class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Bundle f225252a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f225253b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ PDFCtrlViewModel f225254c;

            public b(Bundle r100, int r101, PDFCtrlViewModel r102) {
                this.f225252a = r100;
                this.f225253b = r101;
                this.f225254c = r102;
            }

            public final void a() {
                Bundle r100 = this.f225252a;
                String r101 = "";
                if (r100 == null) goto L6;
                String r102 = r100.toString();
                if (r102 == null) goto L6;
            L7:
                tt5.a.h(PDFCtrlViewModel.TAG, "onInfo what: " + this.f225253b + " msg: " + r102);
                int r103 = this.f225253b;
                int r104 = 0;
                if (r103 != 1000) goto L10;
                this.f225254c.getBookLoaded().postValue(Boolean.TRUE);
                MutableLiveData<Integer> r105 = this.f225254c.m8326getPageCount();
                if (r100 == null) goto L56;
                r104 = r100.getInt("pages");
            L56:
                r105.postValue(Integer.valueOf(r104));
                this.f225254c.getRequestPwd().postValue(1);
                c95.c r106 = PDFCtrlViewModel.access$getShowViewTrackEventCallback$p(this.f225254c);
                if (r106 == null) goto L59;
                r106.b("tt_pdf");
            L59:
                j65.a.c(PDFCtrlViewModel.access$getPreviewViewModel$p(this.f225254c), PDFCtrlViewModel.TAG);
                tt5.a.h(PDFCtrlViewModel.TAG, "trackOpenDowngradeSuccess, openType: tt_pdf");
                HashMap r107 = new HashMap();
                r107.put("open_type", "tt_pdf");
                r107.put("source_type", "3");
                PreviewViewModel r108 = PDFCtrlViewModel.access$getPreviewViewModel$p(this.f225254c);
                if (r108 == null) goto L65;
                t85.g<com.bytedance.ee.bear.drive.view.preview.wrapper.a0> r109 = r108.liveInnerReportMsg();
                if (r109 == null) goto L65;
                r109.a(new com.bytedance.ee.bear.drive.view.preview.wrapper.a0(22, r107));
            L65:
                if (this.f225254c.isPDF() == false) goto L81;
                PDFCtrlViewModel.access$readOutline(this.f225254c);
                return;
            L81:
                return;
            L10:
                if (r103 != 1001) goto L12;
                if (r100 == null) goto L45;
                int r110 = r100.getInt("page");
            L46:
                if (r100 == null) goto L48;
                r104 = r100.getInt("page_count", 0);
            L48:
                this.f225254c.m8326getPageCount().postValue(Integer.valueOf(r104));
                this.f225254c.getIndicator().postValue(Integer.valueOf(r110));
                this.f225254c.getPositionOffset().postValue(Float.valueOf(0.0f));
                PreviewViewModel r111 = PDFCtrlViewModel.access$getPreviewViewModel$p(this.f225254c);
                if (r111 == null) goto L78;
                MutableLiveData<Integer> r112 = r111.currentPageLiveData;
                if (r112 == null) goto L79;
                r112.postValue(Integer.valueOf(r110));
                return;
            L79:
                return;
            L78:
                return;
            L45:
                r110 = 0;
                goto L46
            L12:
                if (r103 != 1004) goto L14;
                if (r100 == null) goto L74;
                PreviewViewModel r113 = PDFCtrlViewModel.access$getPreviewViewModel$p(this.f225254c);
                if (r113 == null) goto L75;
                MutableLiveData<String> r114 = r113.liveInnerRoute();
                if (r114 == null) goto L76;
                String r115 = r100.getString("link");
                if (r115 == null) goto L42;
                r101 = r115;
            L42:
                r114.postValue(r101);
                return;
            L76:
                return;
            L75:
                return;
            L74:
                return;
            L14:
                if (r103 != 1006) goto L16;
                PDFCtrlViewModel.access$setLastClickTime$p(this.f225254c, System.currentTimeMillis());
                com.bytedance.ee.bear.drive.view.preview.ttreader.a r116 = PDFCtrlViewModel.access$getClickHelper$p(this.f225254c);
                if (r116 == null) goto L72;
                r116.f225211f.removeMessages(0);
                r116.f225211f.sendEmptyMessageDelayed(0, 150);
                return;
            L72:
                return;
            L16:
                if (r103 != 1007) goto L18;
                if (r100 == null) goto L26;
                Float r117 = Float.valueOf(r100.getFloat("positionOffset", 0.0f));
            L27:
                this.f225254c.getPositionOffset().postValue(r117);
                if (this.f225254c.getScrollState().getValue() == ScrollState.STOPPED) goto L70;
                this.f225254c.getScrollState().setValue(ScrollState.SCROLLING);
                return;
            L70:
                return;
            L26:
                r117 = null;
                goto L27
            L18:
                if (r103 != 1010) goto L20;
                this.f225254c.getScrollState().setValue(ScrollState.STARTED);
                return;
            L20:
                if (r103 != 1011) goto L82;
                this.f225254c.getScrollState().setValue(ScrollState.STOPPED);
                return;
            L82:
                return;
            L6:
                r102 = "";
                goto L7
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public c(PDFCtrlViewModel r100) {
            this.f225250a = r100;
        }

        @Override // com.bytedance.ee.plugin.common.ttpdfreader.TTPdfReader.Listener
        public final void onError(int r100, Bundle r110) {
            if (r110 == null) goto L5;
            String r111 = r110.toString();
            if (r111 == null) goto L5;
        L6:
            String r112 = "onError what: " + r100 + ", data: " + r111;
            Throwable r101 = new Throwable(r112);
            tt5.a.d(PDFCtrlViewModel.TAG, r112);
            if (r100 == 2002) goto L15;
            if (r100 == 2001) goto L15;
            if (r100 == 5001) goto L15;
            HashMap r113 = new HashMap();
            r113.put("open_type", "tt_pdf");
            r113.put("source_type", "3");
            r113.put("error_message", t85.b.a(r101));
            PreviewViewModel r102 = PDFCtrlViewModel.access$getPreviewViewModel$p(this.f225250a);
            if (r102 == null) goto L15;
            t85.g<com.bytedance.ee.bear.drive.view.preview.wrapper.a0> r103 = r102.liveInnerReportMsg();
            if (r103 == null) goto L15;
            r103.a(new com.bytedance.ee.bear.drive.view.preview.wrapper.a0(21, r113));
        L15:
            if (r100 == 5001) goto L42;
            switch(r100) {
                case 2000: goto L19;
                case 2001: goto L19;
                case 2002: goto L18;
                default: goto L57;
            };
        L18:
            this.f225250a.getRequestPwd().postValue(0);
            return;
        L19:
            j65.a.a(PDFCtrlViewModel.access$getPreviewViewModel$p(this.f225250a), PDFCtrlViewModel.TAG);
            com.bytedance.ee.bear.drive.view.preview.wrapper.z r114 = PDFCtrlViewModel.access$getPreviewFileModel$p(this.f225250a);
            String r104 = null;
            if (r114 == null) goto L22;
            String r115 = r114.f225834b;
        L24:
            if (i75.h.k(r115) == true) goto L30;
            PreviewViewModel r105 = PDFCtrlViewModel.access$getPreviewViewModel$p(this.f225250a);
            if (r105 == null) goto L49;
            MutableLiveData<Integer> r106 = r105.getLiveInnerDowngrade();
            if (r106 == null) goto L50;
            r106.postValue(Integer.valueOf(DriveLocalMime.DOCUMENT.getValue()));
            return;
        L50:
            return;
        L49:
            return;
        L30:
            tt5.a.h(PDFCtrlViewModel.TAG, "pdf show error in pdfView, ignore downgrade, show error");
            PreviewViewModel r116 = PDFCtrlViewModel.access$getPreviewViewModel$p(this.f225250a);
            if (r116 == null) goto L38;
            MutableLiveData<String> r117 = r116.liveInnerUnsupprtPreview();
            if (r117 == null) goto L38;
            com.bytedance.ee.bear.drive.view.preview.wrapper.z r107 = PDFCtrlViewModel.access$getPreviewFileModel$p(this.f225250a);
            if (r107 == null) goto L37;
            r104 = r107.f225834b;
        L37:
            r117.postValue(r104);
        L38:
            if (r100 == 2001) goto L52;
            c95.c r108 = PDFCtrlViewModel.access$getShowViewTrackEventCallback$p(this.f225250a);
            if (r108 == null) goto L53;
            r108.a("tt_pdf", r101);
            return;
        L53:
            return;
        L52:
            return;
        L22:
            r115 = null;
            goto L24
        L57:
            return;
        L42:
            PreviewViewModel.a r109 = new PreviewViewModel.a();
            r109.f225746c = true;
            r109.f225744a = eu5.b.f474075a.getResources().getString(R.string.CreationMobile_Drive_PDFLoading_failed_toast);
            r109.f225748e = eu5.b.f474075a.getResources().getString(R.string.CreationMobile_Drive_PDFLoading_failed_toast_btn);
            PDFCtrlViewModel r118 = this.f225250a;
            r109.f225749f = new a(r118);
            r109.f225747d = 1;
            PreviewViewModel r119 = PDFCtrlViewModel.access$getPreviewViewModel$p(r118);
            if (r119 == null) goto L55;
            MutableLiveData<PreviewViewModel.a> r120 = r119.getLiveInnerChangeTipsState();
            if (r120 == null) goto L56;
            r120.postValue(r109);
            return;
        L56:
            return;
        L55:
            return;
        L5:
            r111 = "";
            goto L6
        }

        @Override // com.bytedance.ee.plugin.common.ttpdfreader.TTPdfReader.Listener
        public final void onInfo(int r100, Bundle r101) {
            if (r101 == null) goto L4;
            Bundle r102 = new Bundle(r101);
        L5:
            com.bytedance.ee.util.ui.j.f(new b(r102, r100, this.f225250a));
            return;
        L4:
            r102 = null;
            goto L5
        }

        @Override // com.bytedance.ee.plugin.common.ttpdfreader.TTPdfReader.Listener
        public final void onReport(String r100, JSONObject r101) {
            tt5.a.b(PDFCtrlViewModel.TAG, "reportEvent: " + r100 + "  jsonObject: " + r101);
            ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).a(r100, r101);
        }
    }

    public static final class d<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PDFCtrlViewModel f225255a;

        public d(PDFCtrlViewModel r100) {
            this.f225255a = r100;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            TTPdfReader r100 = PDFCtrlViewModel.access$getPdfReader$p(this.f225255a);
            if (r100 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
            r100 = null;
        L5:
            List<Bookmark> r101 = r100.getTableOfContents();
            boolean r102 = hu5.a.d(r101);
            tt5.a.h(PDFCtrlViewModel.TAG, "readOutline, isOutlineEmpty= " + r102);
            if (r102 == false) goto L8;
            return;
        L8:
            PDFCtrlViewModel.access$setMShowMenu$p(this.f225255a, true);
            PDFCtrlViewModel r103 = this.f225255a;
            Intrinsics.checkNotNull(r101);
            PDFCtrlViewModel.access$setPdfOutline$p(r103, new j0(r101));
            j0 r104 = PDFCtrlViewModel.access$getPdfOutline$p(this.f225255a);
            Intrinsics.checkNotNull(r104);
            r104.getClass();
            ArrayList<Structure.Paragraph> r105 = new ArrayList();
            r104.a(r104.f225362a, r105);
            Structure r106 = new Structure();
            r106.paragraphs = (Structure.Paragraph[]) r105.toArray(new Structure.Paragraph[0]);
            PDFCtrlViewModel.access$getStructure$p(this.f225255a).postValue(r106);
            TitleBarViewModel r107 = PDFCtrlViewModel.access$getTitleBarViewModel$p(this.f225255a);
            if (r107 == null) goto L12;
            r107.showOutlineMenu();
            return;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e<T> f225256a = null;

        static {
            f225256a = new e();
        }

        public e() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.e(PDFCtrlViewModel.TAG, "readOutline err. ", (Throwable) r100, false);
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PDFCtrlViewModel f225257a;

        public f(PDFCtrlViewModel r100) {
            this.f225257a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        L17:
            return;
        L3:
            if (this.f225257a.isInit() == false) goto L13;
            TTPdfReader r100 = PDFCtrlViewModel.access$getPdfReader$p(this.f225257a);     // Catch: Throwable -> L10
            if (r100 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("pdfReader");     // Catch: Throwable -> L10
            r100 = null;
        L8:
            r100.turnTo(-1);     // Catch: Throwable -> L10
            return;
        }
    }

    static {
        Companion = new a();
    }

    private final void _init() {
        this.bookLoaded.setValue(Boolean.FALSE);
        this.indicator.setValue(0);
        this.pageCount.setValue(0);
        this.positionOffset.setValue(Float.valueOf(0.0f));
        observeNetState();
        observeReader();
    }

    private final void observeNetState() {
        Ref.BooleanRef r100 = new Ref.BooleanRef();
        r100.element = true;
        PreviewViewModel r101 = this.previewViewModel;
        if (r101 == null) goto L8;
        MutableLiveData<Boolean> r102 = r101.liveOuterNetState();
        if (r102 == null) goto L9;
        LifecycleOwner r103 = this.lifecycleOwner;
        Intrinsics.checkNotNull(r103);
        r102.observe(r103, new b(r100, this));
        return;
    L9:
        return;
    }

    private final void observeReader() {
        TTPdfReader r100 = this.pdfReader;
        TTPdfReader r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r100 = null;
    L5:
        r100.setPageErrorTips(eu5.b.f474075a.getString(R.string.Drive_Drive_LoadingFail));
        TTPdfReader r102 = this.pdfReader;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
    L9:
        r101.setListener(new c(this));
        return;
    L8:
        r101 = r102;
        goto L9
    }

    private final void readOutline() {
        boolean r100 = false;
        boolean r101 = com.bytedance.ee.bear.appsetting.c.a.f206237a.i("ccm.drive.pdf_outline_enable", false);
        tt5.a.h("PDFUtils", "isPDFOutlineEnable: " + r101);
        if (r101 == true) goto L5;
        return;
    L5:
        com.bytedance.ee.bear.drive.view.preview.wrapper.z r102 = this.previewFileModel;
        if (r102 != null) goto L8;
    L10:
        if (r100 == false) goto L12;
        return;
    L12:
        Flowable.fromCallable(new d(this)).subscribeOn(fo5.d.c()).subscribe(Functions.emptyConsumer(), e.f225256a);
        return;
    L8:
        if (r102.f225841i != true) goto L10;
        r100 = true;
        goto L10
    }

    public final void dismissOutline() {
        TitleBarViewModel r100 = this.titleBarViewModel;
        if (r100 == null) goto L6;
        r100.dismissOutlineDialog();
        return;
    }

    public final void exitFullscreen() {
        com.bytedance.ee.bear.drive.view.preview.ttreader.a r100 = this.clickHelper;
        if (r100 != null) goto L5;
        return;
    L5:
        if ((System.currentTimeMillis() - r100.f225210e) < 150) goto L10;
        r100.f225211f.removeMessages(2);
        r100.f225211f.sendEmptyMessage(2);
        return;
    }

    public final int findFirstVisiblePage() {
        TTPdfReader r100 = this.pdfReader;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r100 = null;
    L6:
        return r100.findFirstVisiblePage();
    }

    @Override // da5.d
    public String getActive() {
        String r100 = this.activeBookmarkId;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final int getCurrentPageIndex() {
        TTPdfReader r100 = this.pdfReader;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r100 = null;
    L6:
        return r100.getCurrentPage();
    }

    public final int getPageCount() {
        TTPdfReader r100 = this.pdfReader;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r100 = null;
    L6:
        return r100.getTotalPage();
    }

    public final com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.a getPageLoader() {
        if (this.pdfPageLoader != null) goto L13;
        com.bytedance.ee.bear.drive.view.preview.wrapper.z r100 = this.previewFileModel;
        if (r100 == null) goto L8;
        String r101 = r100.f225847o;
        if (r101 == null) goto L8;
    L9:
        TTPdfReader r102 = this.pdfReader;
        if (r102 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r102 = null;
    L12:
        this.pdfPageLoader = new k0(r101, r102);
    L8:
        r101 = "";
    L13:
        com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.a r103 = this.pdfPageLoader;
        Intrinsics.checkNotNull(r103);
        return r103;
    }

    public final View getRenderView() {
        TTPdfReader r100 = this.pdfReader;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r100 = null;
    L6:
        return r100.getView();
    }

    public final boolean isInit() {
        if (this.previewFileModel == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isPDF() {
        com.bytedance.ee.bear.drive.view.preview.wrapper.z r100 = this.previewFileModel;
        if (r100 == null) goto L5;
        String r101 = r100.f225834b;
    L7:
        return i75.h.k(r101);
    L5:
        r101 = null;
        goto L7
    }

    public final boolean isPPT() {
        com.bytedance.ee.bear.drive.view.preview.wrapper.z r100 = this.previewFileModel;
        if (r100 == null) goto L5;
        String r101 = r100.f225834b;
    L7:
        return i75.h.j(r101);
    L5:
        r101 = null;
        goto L7
    }

    public final boolean isStreaming() {
        com.bytedance.ee.bear.drive.view.preview.wrapper.z r100 = this.previewFileModel;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L18;
        PreviewViewModel r102 = this.previewViewModel;
        if (r102 == null) goto L14;
        MutableLiveData<Object> r103 = r102.liveInnerSaveCache();
        if (r103 == null) goto L14;
        Object r104 = r103.getValue();
    L16:
        if ((r104 instanceof VFSPath) == true) goto L18;
        return true;
    L14:
        r104 = null;
    L18:
        return false;
    L5:
        if (r100.f225841i != true) goto L7;
        r101 = true;
        goto L8
    }

    public final void refresh() {
        tt5.a.h(TAG, "refresh() start");
        TTPdfReader r100 = this.pdfReader;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r100 = null;
    L5:
        r100.refresh();
    }

    public final void release() {
        tt5.a.h(TAG, "release. ");
        TTPdfReader r100 = this.pdfReader;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r100 = null;
    L5:
        r100.close();
        TTPdfReader r101 = this.pdfReader;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r101 = null;
    L8:
        r101.setStreamingDownloader(null);
        this.previewFileModel = null;
        this.previewView = null;
        com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.a r102 = this.pdfPageLoader;
        if (r102 == null) goto L11;
        r102.a();
    L11:
        this.pdfPageLoader = null;
        this.pdfOutline = null;
        this.activeBookmarkId = null;
        MutableLiveData<Boolean> r103 = this.bookLoaded;
        Boolean r104 = Boolean.FALSE;
        r103.setValue(r104);
        this.showThumbnail.setValue(r104);
        this.indicator.setValue(0);
        this.pageCount.setValue(0);
        this.requestPwd.setValue(null);
        this.structure.setValue(null);
        this.lifecycleOwner = null;
    }

    public final void removeAllMarks() {
        TTPdfReader r100 = this.pdfReader;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r100 = null;
    L5:
        r100.clearMarks();
    }

    public final void setToFirstPage() {
        scale(1.0f);
        if (Intrinsics.areEqual(this.showThumbnail.getValue(), Boolean.TRUE) == false) goto L5;
        this.showThumbnail.setValue(Boolean.FALSE);
    L5:
        TTPdfReader r100 = this.pdfReader;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r100 = null;
    L8:
        r100.getView().post(new f(this));
    }

    public final void toggleThumbnail() {
        Boolean r100 = this.showThumbnail.getValue();
        if (r100 == null) goto L5;
        boolean r101 = r100.booleanValue();
    L6:
        this.showThumbnail.setValue(Boolean.valueOf(!r101));
        return;
    L5:
        r101 = false;
        goto L6
    }

    public PDFCtrlViewModel() {
        this.bookLoaded = new MutableLiveData();
        this.showThumbnail = new MutableLiveData();
        this.indicator = new MutableLiveData();
        this.pageCount = new MutableLiveData();
        this.requestPwd = new MutableLiveData();
        this.positionOffset = new MutableLiveData();
        this.scrollState = new MutableLiveData();
        this.structure = new MutableLiveData();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        release();
    }

    public final MutableLiveData<Boolean> getBookLoaded() {
        return this.bookLoaded;
    }

    @Override // da5.d
    public LiveData<Structure> getContent() {
        return this.structure;
    }

    public final MutableLiveData<Integer> getIndicator() {
        return this.indicator;
    }

    public final MutableLiveData<Float> getPositionOffset() {
        return this.positionOffset;
    }

    public final MutableLiveData<Integer> getRequestPwd() {
        return this.requestPwd;
    }

    public final MutableLiveData<ScrollState> getScrollState() {
        return this.scrollState;
    }

    public final MutableLiveData<Boolean> getShowThumbnail() {
        return this.showThumbnail;
    }

    public final boolean isShowMenu() {
        return this.mShowMenu;
    }

    /* JADX INFO: renamed from: getPageCount, reason: collision with other method in class */
    public final MutableLiveData<Integer> m8326getPageCount() {
        return this.pageCount;
    }

    public static final /* synthetic */ com.bytedance.ee.bear.drive.view.preview.ttreader.a access$getClickHelper$p(PDFCtrlViewModel r100) {
        return r100.clickHelper;
    }

    public static final /* synthetic */ j0 access$getPdfOutline$p(PDFCtrlViewModel r100) {
        return r100.pdfOutline;
    }

    public static final /* synthetic */ TTPdfReader access$getPdfReader$p(PDFCtrlViewModel r100) {
        return r100.pdfReader;
    }

    public static final /* synthetic */ com.bytedance.ee.bear.drive.view.preview.wrapper.z access$getPreviewFileModel$p(PDFCtrlViewModel r100) {
        return r100.previewFileModel;
    }

    public static final /* synthetic */ PreviewViewModel access$getPreviewViewModel$p(PDFCtrlViewModel r100) {
        return r100.previewViewModel;
    }

    public static final /* synthetic */ c95.c access$getShowViewTrackEventCallback$p(PDFCtrlViewModel r100) {
        return r100.showViewTrackEventCallback;
    }

    public static final /* synthetic */ MutableLiveData access$getStructure$p(PDFCtrlViewModel r100) {
        return r100.structure;
    }

    public static final /* synthetic */ TitleBarViewModel access$getTitleBarViewModel$p(PDFCtrlViewModel r100) {
        return r100.titleBarViewModel;
    }

    public static final /* synthetic */ void access$readOutline(PDFCtrlViewModel r100) {
        r100.readOutline();
    }

    public final float getCurrentPageOffset(int r100) {
        TTPdfReader r101 = this.pdfReader;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r101 = null;
    L6:
        return r101.getCurrentPageOffset(r100);
    }

    public final SizeF getPageResolution(int r100) {
        TTPdfReader r101 = this.pdfReader;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r101 = null;
    L6:
        return r101.getPageResolution(r100);
    }

    public final SizeF getPageSizeF(int r100) {
        TTPdfReader r101 = this.pdfReader;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r101 = null;
    L5:
        if (r100 >= 0) goto L8;
        r100 = 0;
    L8:
        SizeF r102 = r101.getPageSize(r100);
        float r103 = 0.0f;
        if (r102 == null) goto L11;
        float r104 = r102.getWidth();
    L12:
        if (r102 == null) goto L15;
        r103 = r102.getHeight();
    L15:
        return new SizeF(r104, r103);
    L11:
        r104 = 0.0f;
        goto L12
    }

    public final void removeMark(String r100) {
        Intrinsics.checkNotNullParameter(r100, "markId");
        TTPdfReader r101 = this.pdfReader;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r101 = null;
    L5:
        r101.removeMark(r100);
    }

    public final void scale(float r100) {
        TTPdfReader r101 = this.pdfReader;
        TTPdfReader r102 = null;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r101 = null;
    L6:
        if (r101.getScale() != r100) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        return;
    L11:
        TTPdfReader r104 = this.pdfReader;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
    L15:
        r102.setScale(r100);
        return;
    L14:
        r102 = r104;
        goto L15
    L8:
        r103 = false;
        goto L9
    }

    @Override // da5.d
    public void scrollTo(String r100) {
        Intrinsics.checkNotNullParameter(r100, "contentId");
        if (this.pdfOutline != null) goto L5;
        return;
    L5:
        j0 r101 = this.pdfOutline;
        Intrinsics.checkNotNull(r101);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, faceverify.w.BLOB_ELEM_IMAGE_HASHCODE);
        j0.b r102 = r101.f225363b.get(r100);
        if (r102 == null) goto L14;
        int r103 = (int) r102.getPageIdx();
        tt5.a.h(TAG, "Click bookmark, pageIdx: " + r103);
        if (r103 < 0) goto L15;
        TTPdfReader r104 = this.pdfReader;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r104 = null;
    L12:
        r104.turnTo(r103);
        return;
    L15:
        return;
    }

    @Override // da5.d
    public void setActive(String r100) {
        this.activeBookmarkId = r100;
    }

    public final void setTouchEvent(MotionEvent r100) {
        com.bytedance.ee.bear.drive.view.preview.ttreader.a r101 = this.clickHelper;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    public final void turnToPage(int r100) {
        TTPdfReader r101 = this.pdfReader;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r101 = null;
    L5:
        r101.turnTo(r100);
    }

    public final void updateClickTime(long r100) {
        this.lastClickTime = r100;
    }

    public static final /* synthetic */ void access$setLastClickTime$p(PDFCtrlViewModel r100, long r101) {
        r100.lastClickTime = r101;
    }

    public static final /* synthetic */ void access$setMShowMenu$p(PDFCtrlViewModel r100, boolean r101) {
        r100.mShowMenu = r101;
    }

    public static final /* synthetic */ void access$setPdfOutline$p(PDFCtrlViewModel r100, j0 r101) {
        r100.pdfOutline = r101;
    }

    @Override // da5.d
    public void changeCollapseStatus(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, faceverify.w.BLOB_ELEM_IMAGE_HASHCODE);
        if (this.pdfOutline != null) goto L5;
        return;
    L5:
        j0 r102 = this.pdfOutline;
        Intrinsics.checkNotNull(r102);
        boolean r103 = !r101;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, faceverify.w.BLOB_ELEM_IMAGE_HASHCODE);
        j0.b r104 = r102.f225363b.get(r100);
        if (r104 == null) goto L8;
        r104.f225366b = r103;
    L8:
        MutableLiveData<Structure> r105 = this.structure;
        j0 r106 = this.pdfOutline;
        Intrinsics.checkNotNull(r106);
        r106.getClass();
        ArrayList<Structure.Paragraph> r107 = new ArrayList();
        r106.a(r106.f225362a, r107);
        Structure r108 = new Structure();
        r108.paragraphs = (Structure.Paragraph[]) r107.toArray(new Structure.Paragraph[0]);
        r105.setValue(r108);
    }

    public final void openPdf(String r110, a95.a r210) {
        Intrinsics.checkNotNullParameter(r210, "userComponentAbility");
        tt5.a.h(TAG, "openPdf() pwd empty=" + TextUtils.isEmpty(r110));
        c95.c r100 = this.showViewTrackEventCallback;
        if (r100 == null) goto L5;
        r100.onShowStart();
    L5:
        j65.a.b(this.previewViewModel, TAG);
        com.bytedance.ee.bear.drive.view.preview.wrapper.z r101 = this.previewFileModel;
        if (r101 == null) goto L15;
        LinkedHashMap<String, String> r102 = r101.f225838f;
        if (r102 == null) goto L15;
        Set<Map.Entry<String, String>> r103 = r102.entrySet();
        if (r103 == null) goto L15;
        Iterator<Map.Entry<String, String>> r104 = r103.iterator();
        Uri r105 = null;
    L13:
        if (r104.hasNext() == false) goto L16;
        r105 = UriProtector.parse(r104.next().getValue());
    L16:
        com.bytedance.ee.bear.drive.view.preview.wrapper.z r106 = this.previewFileModel;
        if (r106 != null) goto L19;
    L21:
        boolean r107 = false;
    L22:
        if (r107 == false) goto L25;
        if (r105 == null) goto L25;
        tt5.a.h(TAG, "openPdf() by streaming...");
        Uri r111 = r105;
    L35:
        Application r108 = eu5.b.f474075a;
        DriveFilePath r109 = com.bytedance.ee.bear.drive.cache.t.h();
        StringBuilder r112 = new StringBuilder();
        PreviewViewModel r113 = this.previewViewModel;
        if (r113 == null) goto L38;
        Integer r114 = Integer.valueOf(r113.getBizType());
    L39:
        r112.append(r114);
        r112.append('_');
        com.bytedance.ee.bear.drive.view.preview.wrapper.z r115 = this.previewFileModel;
        if (r115 == null) goto L42;
        String r116 = r115.f225847o;
    L43:
        r112.append(r116);
        r112.append('_');
        com.bytedance.ee.bear.drive.view.preview.wrapper.z r117 = this.previewFileModel;
        if (r117 == null) goto L46;
        String r118 = r117.f225846n;
    L47:
        r112.append(r118);
        r112.append(".pdf");
        r109.cacheName(r112.toString());
        StringBuilder r119 = new StringBuilder("openPdf, streamingFilePath: ");
        Intrinsics.checkNotNull(r109);
        String r120 = z75.b.b(r109, r210.f2278b).getRealPath();
        if (r120 != null) goto L50;
        r120 = null;
    L50:
        r119.append(du5.b.f(r120));
        r119.append(", previewFileSize: ");
        com.bytedance.ee.bear.drive.view.preview.wrapper.z r121 = this.previewFileModel;
        if (r121 == null) goto L53;
        Long r122 = Long.valueOf(r121.f225843k);
    L54:
        r119.append(r122);
        r119.append(", uri: ");
        r119.append(du5.b.g(r111.toString()));
        r119.append(", apiExtra: ");
        com.bytedance.ee.bear.drive.view.preview.wrapper.z r123 = this.previewFileModel;
        if (r123 == null) goto L57;
        String r124 = r123.f225851s;
    L58:
        r119.append(r124);
        r119.append(", dataVersion: ");
        com.bytedance.ee.bear.drive.view.preview.wrapper.z r125 = this.previewFileModel;
        if (r125 == null) goto L61;
        String r126 = r125.f225846n;
    L62:
        r119.append(r126);
        tt5.a.h(TAG, r119.toString());
        TTPdfReader r127 = this.pdfReader;
        if (r127 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        TTPdfReader r128 = null;
    L66:
        com.bytedance.ee.bear.drive.view.preview.wrapper.z r129 = this.previewFileModel;
        String r130 = "";
        if (r129 == null) goto L72;
        String r131 = r129.f225847o;
        if (r131 == null) goto L72;
        String r132 = r131;
    L73:
        String r133 = r111.toString();
        com.bytedance.ee.bear.drive.view.preview.wrapper.z r134 = this.previewFileModel;
        if (r134 == null) goto L76;
        long r135 = r134.f225843k;
    L77:
        if (r134 == null) goto L80;
        String r136 = r134.f225851s;
        if (r136 == null) goto L80;
    L81:
        if (r134 == null) goto L84;
        String r137 = r134.f225846n;
        if (r137 == null) goto L84;
    L85:
        if (r134 == null) goto L90;
        String r138 = r134.f225852t;
        if (r138 == null) goto L90;
        String r139 = r138;
    L91:
        PreviewViewModel r140 = this.previewViewModel;
        if (r140 == null) goto L94;
        MutableLiveData<Object> r141 = r140.liveInnerSaveCache();
    L95:
        r128.setStreamingDownloader(new PDFStreamingDownloader(r132, r133, r109, r135, r136, r137, r139, r141, r210));
        com.bytedance.ee.bear.drive.view.preview.wrapper.z r142 = this.previewFileModel;
        if (r142 == null) goto L99;
        String r143 = r142.f225835c;
        if (r143 == null) goto L99;
    L100:
        if (r142 == null) goto L106;
        String r144 = r142.f225834b;
        if (r144 == null) goto L106;
        r130 = r144;
    L106:
        if (TextUtils.isEmpty(r143) == false) goto L109;
        r143 = r130;
    L109:
        TTPdfReader r145 = this.pdfReader;
        if (r145 != null) goto L112;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        TTPdfReader r146 = null;
    L113:
        r146.open(r111, r110, r143);
        return;
    L112:
        r146 = r145;
    L99:
        r143 = "";
        goto L100
    L94:
        r141 = null;
    L90:
        r139 = "";
    L84:
        r137 = "";
    L80:
        r136 = "";
        goto L81
    L76:
        r135 = 0;
    L72:
        r132 = "";
        goto L73
    L65:
        r128 = r127;
        goto L66
    L61:
        r126 = null;
        goto L62
    L57:
        r124 = null;
        goto L58
    L53:
        r122 = null;
        goto L54
    L46:
        r118 = null;
        goto L47
    L42:
        r116 = null;
        goto L43
    L38:
        r114 = null;
    L25:
        if (r106 == null) goto L28;
        DriveFilePath r147 = r106.f225836d;
        if (r147 == null) goto L28;
    L29:
        VFSFile r148 = z75.b.e(r147, r210.f2278b);
        tt5.a.h(TAG, "openPdf() by local file=" + r148 + " size=" + r148.length());
        Uri r149 = Uri.fromFile(r148);
        if (r148.isDirectory() == false) goto L32;
    L115:
        tt5.a.h(TAG, "file not found, try to reload, fileErrorReloadTime=" + this.fileErrorReloadTime);
        if (this.fileErrorReloadTime < 2) goto L118;
        return;
    L118:
        if (isInit() == false) goto L127;
        this.fileErrorReloadTime++;
        PreviewViewModel r150 = this.previewViewModel;
        if (r150 == null) goto L128;
        MutableLiveData<Void> r151 = r150.liveInnerReload();
        if (r151 == null) goto L129;
        r151.postValue(null);
        return;
    L129:
        return;
    L128:
        return;
    L127:
        return;
    L32:
        if (r147.isEmpty() == true) goto L115;
        r111 = r149;
    L28:
        DriveFilePath.Companion.getClass();
        r147 = DriveFilePath.a.a();
        goto L29
    L19:
        if (r106.f225841i != true) goto L21;
        r107 = true;
    L15:
        r105 = null;
        goto L16
    }

    public final void scrollYOffset(int r100, int r101) {
        TTPdfReader r102 = this.pdfReader;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r102 = null;
    L5:
        r102.scrollY(r100, r101);
    }

    public final void updateAreaMarkColor(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "markId");
        TTPdfReader r102 = this.pdfReader;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r102 = null;
    L5:
        r102.updateAreaMarkStyle(r100, 8, r101, 0);
    }

    public final void updateContentMarkColor(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "markId");
        TTPdfReader r102 = this.pdfReader;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r102 = null;
    L5:
        r102.updateAreaMarkStyle(r100, 0, 0, r101);
    }

    public final PagePart getPageForPresentation(int r110, int r111, int r112) {
        TTPdfReader r100 = this.pdfReader;     // Catch: Throwable -> L11
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");     // Catch: Throwable -> L11
        r100 = null;
    L6:
        if (r110 < 0) goto L8;
        int r101 = r110;
    L9:
        return r100.loadPageSync(r101, r111 * 1.0f, r112 * 1.0f, new RectF(0.0f, 0.0f, 1.0f, 1.0f), false, true);
    L8:
        r101 = 0;
    L11:
        th = move-exception;
        tt5.a.f(TAG, th, false);
        return null;
    }

    public final void markArea(String r110, int r111, List<? extends RectF> r112, int r113, boolean r114, boolean r115) {
        Intrinsics.checkNotNullParameter(r110, "markId");
        Intrinsics.checkNotNullParameter(r112, "contentAreaRates");
        TTPdfReader r100 = this.pdfReader;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r100 = null;
    L5:
        r100.markAreas(r110, r111, r112, 8, r113, 0, r114, r115);
    }

    public final void markContent(String r110, int r111, List<? extends RectF> r112, int r113, boolean r114, boolean r115) {
        Intrinsics.checkNotNullParameter(r110, "markId");
        Intrinsics.checkNotNullParameter(r112, "contentAreaRates");
        TTPdfReader r100 = this.pdfReader;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r100 = null;
    L5:
        r100.markAreas(r110, r111, r112, 0, 0, r113, r114, r115);
    }

    public final void init(LifecycleOwner r100, TTPdfReader r101, com.bytedance.ee.bear.drive.view.preview.wrapper.z r102, PreviewViewModel r103, TitleBarViewModel r104, com.bytedance.ee.bear.drive.view.preview.wrapper.m r105, com.bytedance.ee.bear.drive.view.preview.ttreader.a r106, c95.c r107, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r101, "pdfReader");
        Intrinsics.checkNotNullParameter(r105, "previewView");
        Intrinsics.checkNotNullParameter(r106, "clickHelper");
        this.pdfReader = r101;
        this.previewFileModel = r102;
        this.previewViewModel = r103;
        this.titleBarViewModel = r104;
        this.previewView = r105;
        this.clickHelper = r106;
        this.showViewTrackEventCallback = r107;
        this.lifecycleOwner = r100;
        r101.setMaxScale(o75.b.a().getDriveConfig().a().getPdfMaxScale());
        r101.setMinScale(o75.b.a().getDriveConfig().a().getPdfMinScale());
        if (r110 == false) goto L5;
        r101.setMaxScale(1.0f);
        r101.setMinScale(1.0f);
    L5:
        _init();
    }
}
