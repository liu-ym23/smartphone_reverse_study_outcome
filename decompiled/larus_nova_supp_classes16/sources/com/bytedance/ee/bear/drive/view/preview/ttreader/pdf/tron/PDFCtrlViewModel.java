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
import com.bytedance.ee.plugin.common.ttpdfreader.PagePart;
import com.bytedance.ee.plugin.common.ttpdfreader.TTPdfReader;
import com.bytedance.lark.lark_markdown_render_android.BuildConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 z2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001zB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u00105\u001a\u00020\u0018J\b\u00106\u001a\u000207H\u0002J\u0006\u00108\u001a\u00020\u0018J\u0006\u0010!\u001a\u00020\u001eJ\u0006\u00109\u001a\u00020\u001eJ\u0006\u0010:\u001a\u00020;J\u000e\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u001eJ\u000e\u0010?\u001a\u00020=2\u0006\u0010@\u001a\u00020\u001eJ\u0006\u0010A\u001a\u00020+J\u0006\u0010B\u001a\u000207J\u000e\u0010C\u001a\u0002072\u0006\u0010>\u001a\u00020\u001eJ\u0016\u0010D\u001a\u0002072\u0006\u0010>\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020\u001eJ\u000e\u0010F\u001a\u00020%2\u0006\u0010>\u001a\u00020\u001eJ\u000e\u0010G\u001a\u0002072\u0006\u0010G\u001a\u00020%J\u0006\u0010H\u001a\u000207J\u0006\u0010I\u001a\u000207J\u0010\u0010J\u001a\u0002072\b\u0010K\u001a\u0004\u0018\u00010LJ\u0006\u0010M\u001a\u000207J\b\u0010N\u001a\u000207H\u0002J\b\u0010O\u001a\u000207H\u0002J\b\u0010P\u001a\u000207H\u0003J\u0018\u0010Q\u001a\u0002072\b\u0010R\u001a\u0004\u0018\u0001032\u0006\u0010S\u001a\u00020TJ\u000e\u0010U\u001a\u0002072\u0006\u0010V\u001a\u00020-J\u0006\u0010W\u001a\u00020\u0018J\u0006\u0010X\u001a\u000207J\b\u0010Y\u001a\u000207H\u0014J\u0006\u0010Z\u001a\u000207JV\u0010[\u001a\u0002072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\\\u001a\u00020\u0018J\u0010\u0010]\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030^H\u0016J\u0010\u0010_\u001a\u0002072\u0006\u0010`\u001a\u000203H\u0016J\u0012\u0010a\u001a\u0002072\b\u0010`\u001a\u0004\u0018\u000103H\u0016J\b\u0010b\u001a\u000203H\u0016J\u0018\u0010c\u001a\u0002072\u0006\u0010d\u001a\u0002032\u0006\u0010e\u001a\u00020\u0018H\u0016J \u0010f\u001a\u0004\u0018\u00010g2\u0006\u0010>\u001a\u00020\u001e2\u0006\u0010h\u001a\u00020\u001e2\u0006\u0010i\u001a\u00020\u001eJ\u0006\u0010j\u001a\u00020\u0018J\u0006\u0010k\u001a\u00020\u0018J\u0006\u0010l\u001a\u00020\u001eJ<\u0010m\u001a\u0002072\u0006\u0010n\u001a\u0002032\u0006\u0010@\u001a\u00020\u001e2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020q0p2\u0006\u0010r\u001a\u00020\u001e2\u0006\u0010s\u001a\u00020\u00182\u0006\u0010t\u001a\u00020\u0018J\u0016\u0010u\u001a\u0002072\u0006\u0010n\u001a\u0002032\u0006\u0010r\u001a\u00020\u001eJ<\u0010v\u001a\u0002072\u0006\u0010n\u001a\u0002032\u0006\u0010@\u001a\u00020\u001e2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020q0p2\u0006\u0010r\u001a\u00020\u001e2\u0006\u0010s\u001a\u00020\u00182\u0006\u0010t\u001a\u00020\u0018J\u0016\u0010w\u001a\u0002072\u0006\u0010n\u001a\u0002032\u0006\u0010r\u001a\u00020\u001eJ\u000e\u0010x\u001a\u0002072\u0006\u0010n\u001a\u000203J\u0006\u0010y\u001a\u000207R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\u0017¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0019\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u0017¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0019\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0\u0017¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u0017¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006{"}, d2 = {"Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFCtrlViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/structure/ScrollableNavigation;", "Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/structure/Structure;", "<init>", "()V", "pdfReader", "Lcom/bytedance/ee/plugin/common/ttpdfreader/TTPdfReader;", "previewFileModel", "Lcom/bytedance/ee/bear/drive/view/preview/wrapper/PreviewFileModel;", "previewViewModel", "Lcom/bytedance/ee/bear/drive/view/preview/wrapper/PreviewViewModel;", "titleBarViewModel", "Lcom/bytedance/ee/bear/drive/view/preview/wrapper/TitleBarViewModel;", "previewView", "Lcom/bytedance/ee/bear/drive/view/preview/wrapper/IPreviewView;", "clickHelper", "Lcom/bytedance/ee/bear/drive/view/preview/ttreader/TTClickHelper;", "showViewTrackEventCallback", "Lcom/bytedance/ee/bear/drive/view/preview/OnShowViewTrackEventCallback;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "bookLoaded", "Landroidx/lifecycle/MutableLiveData;", "", "getBookLoaded", "()Landroidx/lifecycle/MutableLiveData;", "showThumbnail", "getShowThumbnail", "indicator", "", "getIndicator", "pageCount", "getPageCount", "requestPwd", "getRequestPwd", "positionOffset", "", "getPositionOffset", "scrollState", "Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/structure/ScrollState;", "getScrollState", "pdfPageLoader", "Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/IPDFPageLoader;", "lastClickTime", "", "mShowMenu", "pdfOutline", "Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFOutline;", "structure", "activeBookmarkId", "", "fileErrorReloadTime", "isInit", "_init", "", "isShowMenu", "getCurrentPageIndex", "getRenderView", "Landroid/view/View;", "getPageSizeF", "Landroid/util/SizeF;", "page", "getPageResolution", "pageIndex", "getPageLoader", "toggleThumbnail", "turnToPage", "scrollYOffset", "offset", "getCurrentPageOffset", "scale", "setToFirstPage", "dismissOutline", "setTouchEvent", "ev", "Landroid/view/MotionEvent;", "exitFullscreen", "observeNetState", "observeReader", "readOutline", "openPdf", "password", "userComponentAbility", "Lcom/bytedance/ee/bear/drive/usercomponent/DriveUserComponentAbility;", "updateClickTime", "time", "isStreaming", "refresh", "onCleared", BuildConfig.BUILD_TYPE, "init", "inVC", "getContent", "Landroidx/lifecycle/LiveData;", "scrollTo", "contentId", "setActive", "getActive", "changeCollapseStatus", "hash", "status", "getPageForPresentation", "Lcom/bytedance/ee/plugin/common/ttpdfreader/PagePart;", "w", "h", "isPPT", "isPDF", "findFirstVisiblePage", "markContent", "markId", "contentAreaRates", "", "Landroid/graphics/RectF;", "color", "clickable", "countable", "updateContentMarkColor", "markArea", "updateAreaMarkColor", "removeMark", "removeAllMarks", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
        public final /* synthetic */ Ref.BooleanRef a;
        public final /* synthetic */ PDFCtrlViewModel b;

        public b(Ref.BooleanRef r1, PDFCtrlViewModel r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r3) {
            Boolean r4 = (Boolean) r3;
            Ref.BooleanRef r0 = this.a;
            if (r0.element == false) goto L6;
            r0.element = false;
            return;
        L6:
            if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L10;
            this.b.refresh();
            return;
        }
    }

    public static final class c implements TTPdfReader.Listener {
        public final /* synthetic */ PDFCtrlViewModel a;

        public static final class a implements View.OnClickListener {
            public final /* synthetic */ PDFCtrlViewModel a;

            public a(PDFCtrlViewModel r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r2) {
                tt5.a.h(PDFCtrlViewModel.TAG, "banner click retry");
                this.a.refresh();
            }
        }

        public static final class b implements Runnable {
            public final /* synthetic */ Bundle a;
            public final /* synthetic */ int b;
            public final /* synthetic */ PDFCtrlViewModel c;

            public b(Bundle r1, int r2, PDFCtrlViewModel r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            public final void a() {
                Bundle r0 = this.a;
                String r1 = "";
                if (r0 == null) goto L6;
                String r2 = r0.toString();
                if (r2 == null) goto L6;
            L7:
                tt5.a.h(PDFCtrlViewModel.TAG, "onInfo what: " + this.b + " msg: " + r2);
                int r3 = this.b;
                int r5 = 0;
                if (r3 != 1000) goto L10;
                this.c.getBookLoaded().postValue(Boolean.TRUE);
                MutableLiveData<Integer> r4 = this.c.m372getPageCount();
                if (r0 == null) goto L56;
                r5 = r0.getInt("pages");
            L56:
                r4.postValue(Integer.valueOf(r5));
                this.c.getRequestPwd().postValue(1);
                c95.c r6 = PDFCtrlViewModel.access$getShowViewTrackEventCallback$p(this.c);
                if (r6 == null) goto L59;
                r6.b("tt_pdf");
            L59:
                j65.a.c(PDFCtrlViewModel.access$getPreviewViewModel$p(this.c), PDFCtrlViewModel.TAG);
                tt5.a.h(PDFCtrlViewModel.TAG, "trackOpenDowngradeSuccess, openType: tt_pdf");
                HashMap r7 = new HashMap();
                r7.put("open_type", "tt_pdf");
                r7.put("source_type", "3");
                PreviewViewModel r8 = PDFCtrlViewModel.access$getPreviewViewModel$p(this.c);
                if (r8 == null) goto L65;
                t85.g<com.bytedance.ee.bear.drive.view.preview.wrapper.a0> r9 = r8.liveInnerReportMsg();
                if (r9 == null) goto L65;
                r9.a(new com.bytedance.ee.bear.drive.view.preview.wrapper.a0(22, r7));
            L65:
                if (this.c.isPDF() == false) goto L81;
                PDFCtrlViewModel.access$readOutline(this.c);
                return;
            L81:
                return;
            L10:
                if (r3 != 1001) goto L12;
                if (r0 == null) goto L45;
                int r10 = r0.getInt("page");
            L46:
                if (r0 == null) goto L48;
                r5 = r0.getInt("page_count", 0);
            L48:
                this.c.m372getPageCount().postValue(Integer.valueOf(r5));
                this.c.getIndicator().postValue(Integer.valueOf(r10));
                this.c.getPositionOffset().postValue(Float.valueOf(0.0f));
                PreviewViewModel r11 = PDFCtrlViewModel.access$getPreviewViewModel$p(this.c);
                if (r11 == null) goto L78;
                MutableLiveData<Integer> r12 = r11.currentPageLiveData;
                if (r12 == null) goto L79;
                r12.postValue(Integer.valueOf(r10));
                return;
            L79:
                return;
            L78:
                return;
            L45:
                r10 = 0;
                goto L46
            L12:
                if (r3 != 1004) goto L14;
                if (r0 == null) goto L74;
                PreviewViewModel r13 = PDFCtrlViewModel.access$getPreviewViewModel$p(this.c);
                if (r13 == null) goto L75;
                MutableLiveData<String> r14 = r13.liveInnerRoute();
                if (r14 == null) goto L76;
                String r16 = r0.getString("link");
                if (r16 == null) goto L42;
                r1 = r16;
            L42:
                r14.postValue(r1);
                return;
            L76:
                return;
            L75:
                return;
            L74:
                return;
            L14:
                if (r3 != 1006) goto L16;
                PDFCtrlViewModel.access$setLastClickTime$p(this.c, System.currentTimeMillis());
                com.bytedance.ee.bear.drive.view.preview.ttreader.a r17 = PDFCtrlViewModel.access$getClickHelper$p(this.c);
                if (r17 == null) goto L72;
                r17.f.removeMessages(0);
                r17.f.sendEmptyMessageDelayed(0, 150);
                return;
            L72:
                return;
            L16:
                if (r3 != 1007) goto L18;
                if (r0 == null) goto L26;
                Float r18 = Float.valueOf(r0.getFloat("positionOffset", 0.0f));
            L27:
                this.c.getPositionOffset().postValue(r18);
                if (this.c.getScrollState().getValue() == ScrollState.STOPPED) goto L70;
                this.c.getScrollState().setValue(ScrollState.SCROLLING);
                return;
            L70:
                return;
            L26:
                r18 = null;
                goto L27
            L18:
                if (r3 != 1010) goto L20;
                this.c.getScrollState().setValue(ScrollState.STARTED);
                return;
            L20:
                if (r3 != 1011) goto L82;
                this.c.getScrollState().setValue(ScrollState.STOPPED);
                return;
            L82:
                return;
            L6:
                r2 = "";
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

        public c(PDFCtrlViewModel r1) {
            this.a = r1;
        }

        public final void onError(int r9, Bundle r10) {
            if (r10 == null) goto L5;
            String r11 = r10.toString();
            if (r11 == null) goto L5;
        L6:
            String r12 = "onError what: " + r9 + ", data: " + r11;
            Throwable r0 = new Throwable(r12);
            tt5.a.d(PDFCtrlViewModel.TAG, r12);
            if (r9 == 2002) goto L15;
            if (r9 == 2001) goto L15;
            if (r9 == 5001) goto L15;
            HashMap r13 = new HashMap();
            r13.put("open_type", "tt_pdf");
            r13.put("source_type", "3");
            r13.put("error_message", t85.b.a(r0));
            PreviewViewModel r5 = PDFCtrlViewModel.access$getPreviewViewModel$p(this.a);
            if (r5 == null) goto L15;
            t85.g<com.bytedance.ee.bear.drive.view.preview.wrapper.a0> r6 = r5.liveInnerReportMsg();
            if (r6 == null) goto L15;
            r6.a(new com.bytedance.ee.bear.drive.view.preview.wrapper.a0(21, r13));
        L15:
            if (r9 == 5001) goto L42;
            switch(r9) {
                case 2000: goto L19;
                case 2001: goto L19;
                case 2002: goto L18;
                default: goto L57;
            };
        L18:
            this.a.getRequestPwd().postValue(0);
            return;
        L19:
            j65.a.a(PDFCtrlViewModel.access$getPreviewViewModel$p(this.a), PDFCtrlViewModel.TAG);
            com.bytedance.ee.bear.drive.view.preview.wrapper.z r14 = PDFCtrlViewModel.access$getPreviewFileModel$p(this.a);
            String r4 = null;
            if (r14 == null) goto L22;
            String r16 = r14.b;
        L24:
            if (i75.h.k(r16) == true) goto L30;
            PreviewViewModel r17 = PDFCtrlViewModel.access$getPreviewViewModel$p(this.a);
            if (r17 == null) goto L49;
            MutableLiveData<Integer> r18 = r17.getLiveInnerDowngrade();
            if (r18 == null) goto L50;
            r18.postValue(Integer.valueOf(DriveLocalMime.DOCUMENT.getValue()));
            return;
        L50:
            return;
        L49:
            return;
        L30:
            tt5.a.h(PDFCtrlViewModel.TAG, "pdf show error in pdfView, ignore downgrade, show error");
            PreviewViewModel r19 = PDFCtrlViewModel.access$getPreviewViewModel$p(this.a);
            if (r19 == null) goto L38;
            MutableLiveData<String> r110 = r19.liveInnerUnsupprtPreview();
            if (r110 == null) goto L38;
            com.bytedance.ee.bear.drive.view.preview.wrapper.z r1 = PDFCtrlViewModel.access$getPreviewFileModel$p(this.a);
            if (r1 == null) goto L37;
            r4 = r1.b;
        L37:
            r110.postValue(r4);
        L38:
            if (r9 == 2001) goto L52;
            c95.c r20 = PDFCtrlViewModel.access$getShowViewTrackEventCallback$p(this.a);
            if (r20 == null) goto L53;
            r20.a("tt_pdf", r0);
            return;
        L53:
            return;
        L52:
            return;
        L22:
            r16 = null;
            goto L24
        L57:
            return;
        L42:
            PreviewViewModel.a r21 = new PreviewViewModel.a();
            r21.c = true;
            r21.a = eu5.b.a.getResources().getString(2131887235);
            r21.e = eu5.b.a.getResources().getString(2131887236);
            PDFCtrlViewModel r2 = this.a;
            r21.f = new a(r2);
            r21.d = 1;
            PreviewViewModel r111 = PDFCtrlViewModel.access$getPreviewViewModel$p(r2);
            if (r111 == null) goto L55;
            MutableLiveData<PreviewViewModel.a> r112 = r111.getLiveInnerChangeTipsState();
            if (r112 == null) goto L56;
            r112.postValue(r21);
            return;
        L56:
            return;
        L55:
            return;
        L5:
            r11 = "";
            goto L6
        }

        public final void onInfo(int r3, Bundle r4) {
            if (r4 == null) goto L4;
            Bundle r0 = new Bundle(r4);
        L5:
            com.bytedance.ee.util.ui.j.f(new b(r0, r3, this.a));
            return;
        L4:
            r0 = null;
            goto L5
        }

        public final void onReport(String r4, JSONObject r5) {
            tt5.a.b(PDFCtrlViewModel.TAG, "reportEvent: " + r4 + "  jsonObject: " + r5);
            ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).a(r4, r5);
        }
    }

    public static final class d<V> implements Callable {
        public final /* synthetic */ PDFCtrlViewModel a;

        public d(PDFCtrlViewModel r1) {
            this.a = r1;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            TTPdfReader r0 = PDFCtrlViewModel.access$getPdfReader$p(this.a);
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
            r0 = null;
        L5:
            List r1 = r0.getTableOfContents();
            boolean r2 = hu5.a.d(r1);
            tt5.a.h(PDFCtrlViewModel.TAG, "readOutline, isOutlineEmpty= " + r2);
            if (r2 == false) goto L8;
            return;
        L8:
            PDFCtrlViewModel.access$setMShowMenu$p(this.a, true);
            PDFCtrlViewModel r3 = this.a;
            Intrinsics.checkNotNull(r1);
            PDFCtrlViewModel.access$setPdfOutline$p(r3, new j0(r1));
            j0 r4 = PDFCtrlViewModel.access$getPdfOutline$p(this.a);
            Intrinsics.checkNotNull(r4);
            r4.getClass();
            ArrayList<Structure.Paragraph> r5 = new ArrayList();
            r4.a(r4.a, r5);
            Structure r6 = new Structure();
            r6.paragraphs = (Structure.Paragraph[]) r5.toArray(new Structure.Paragraph[0]);
            PDFCtrlViewModel.access$getStructure$p(this.a).postValue(r6);
            TitleBarViewModel r7 = PDFCtrlViewModel.access$getTitleBarViewModel$p(this.a);
            if (r7 == null) goto L12;
            r7.showOutlineMenu();
            return;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    public static final class e<T> implements Consumer {
        public static final e<T> a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r4) {
            tt5.a.e(PDFCtrlViewModel.TAG, "readOutline err. ", (Throwable) r4, false);
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ PDFCtrlViewModel a;

        public f(PDFCtrlViewModel r1) {
            this.a = r1;
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
            if (this.a.isInit() == false) goto L13;
            TTPdfReader r0 = PDFCtrlViewModel.access$getPdfReader$p(this.a);     // Catch: Throwable -> L10
            if (r0 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("pdfReader");     // Catch: Throwable -> L10
            r0 = null;
        L8:
            r0.turnTo(-1);     // Catch: Throwable -> L10
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
        Ref.BooleanRef r0 = new Ref.BooleanRef();
        r0.element = true;
        PreviewViewModel r1 = this.previewViewModel;
        if (r1 == null) goto L8;
        MutableLiveData<Boolean> r2 = r1.liveOuterNetState();
        if (r2 == null) goto L9;
        LifecycleOwner r3 = this.lifecycleOwner;
        Intrinsics.checkNotNull(r3);
        r2.observe(r3, new b(r0, this));
        return;
    L9:
        return;
    }

    private final void observeReader() {
        TTPdfReader r0 = this.pdfReader;
        TTPdfReader r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r0 = null;
    L5:
        r0.setPageErrorTips(eu5.b.a.getString(2131888419));
        TTPdfReader r2 = this.pdfReader;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
    L9:
        r1.setListener(new c(this));
        return;
    L8:
        r1 = r2;
        goto L9
    }

    private final void readOutline() {
        boolean r2 = false;
        boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.i("ccm.drive.pdf_outline_enable", false);
        tt5.a.h("PDFUtils", "isPDFOutlineEnable: " + r0);
        if (r0 == true) goto L5;
        return;
    L5:
        com.bytedance.ee.bear.drive.view.preview.wrapper.z r1 = this.previewFileModel;
        if (r1 != null) goto L8;
    L10:
        if (r2 == false) goto L12;
        return;
    L12:
        Flowable.fromCallable(new d(this)).subscribeOn(fo5.d.c()).subscribe(Functions.emptyConsumer(), e.a);
        return;
    L8:
        if (r1.i != true) goto L10;
        r2 = true;
        goto L10
    }

    public final void dismissOutline() {
        TitleBarViewModel r0 = this.titleBarViewModel;
        if (r0 == null) goto L6;
        r0.dismissOutlineDialog();
        return;
    }

    public final void exitFullscreen() {
        com.bytedance.ee.bear.drive.view.preview.ttreader.a r0 = this.clickHelper;
        if (r0 != null) goto L5;
        return;
    L5:
        if ((System.currentTimeMillis() - r0.e) < 150) goto L10;
        r0.f.removeMessages(2);
        r0.f.sendEmptyMessage(2);
        return;
    }

    public final int findFirstVisiblePage() {
        TTPdfReader r0 = this.pdfReader;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r0 = null;
    L6:
        return r0.findFirstVisiblePage();
    }

    @Override // da5.d
    public String getActive() {
        String r0 = this.activeBookmarkId;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final int getCurrentPageIndex() {
        TTPdfReader r0 = this.pdfReader;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r0 = null;
    L6:
        return r0.getCurrentPage();
    }

    public final int getPageCount() {
        TTPdfReader r0 = this.pdfReader;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r0 = null;
    L6:
        return r0.getTotalPage();
    }

    public final com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.a getPageLoader() {
        if (this.pdfPageLoader != null) goto L13;
        com.bytedance.ee.bear.drive.view.preview.wrapper.z r1 = this.previewFileModel;
        if (r1 == null) goto L8;
        String r2 = r1.o;
        if (r2 == null) goto L8;
    L9:
        TTPdfReader r3 = this.pdfReader;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r3 = null;
    L12:
        this.pdfPageLoader = new k0(r2, r3);
    L8:
        r2 = "";
    L13:
        com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.a r0 = this.pdfPageLoader;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public final View getRenderView() {
        TTPdfReader r0 = this.pdfReader;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r0 = null;
    L6:
        return r0.getView();
    }

    public final boolean isInit() {
        if (this.previewFileModel == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isPDF() {
        com.bytedance.ee.bear.drive.view.preview.wrapper.z r0 = this.previewFileModel;
        if (r0 == null) goto L5;
        String r1 = r0.b;
    L7:
        return i75.h.k(r1);
    L5:
        r1 = null;
        goto L7
    }

    public final boolean isPPT() {
        com.bytedance.ee.bear.drive.view.preview.wrapper.z r0 = this.previewFileModel;
        if (r0 == null) goto L5;
        String r1 = r0.b;
    L7:
        return i75.h.j(r1);
    L5:
        r1 = null;
        goto L7
    }

    public final boolean isStreaming() {
        com.bytedance.ee.bear.drive.view.preview.wrapper.z r0 = this.previewFileModel;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L18;
        PreviewViewModel r2 = this.previewViewModel;
        if (r2 == null) goto L14;
        MutableLiveData<Object> r3 = r2.liveInnerSaveCache();
        if (r3 == null) goto L14;
        Object r4 = r3.getValue();
    L16:
        if ((r4 instanceof VFSPath) == true) goto L18;
        return true;
    L14:
        r4 = null;
    L18:
        return false;
    L5:
        if (r0.i != true) goto L7;
        r1 = true;
        goto L8
    }

    public final void refresh() {
        tt5.a.h(TAG, "refresh() start");
        TTPdfReader r0 = this.pdfReader;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r0 = null;
    L5:
        r0.refresh();
    }

    public final void release() {
        tt5.a.h(TAG, "release. ");
        TTPdfReader r0 = this.pdfReader;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r0 = null;
    L5:
        r0.close();
        TTPdfReader r1 = this.pdfReader;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r1 = null;
    L8:
        r1.setStreamingDownloader(null);
        this.previewFileModel = null;
        this.previewView = null;
        com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.a r2 = this.pdfPageLoader;
        if (r2 == null) goto L11;
        r2.a();
    L11:
        this.pdfPageLoader = null;
        this.pdfOutline = null;
        this.activeBookmarkId = null;
        MutableLiveData<Boolean> r3 = this.bookLoaded;
        Boolean r4 = Boolean.FALSE;
        r3.setValue(r4);
        this.showThumbnail.setValue(r4);
        this.indicator.setValue(0);
        this.pageCount.setValue(0);
        this.requestPwd.setValue(null);
        this.structure.setValue(null);
        this.lifecycleOwner = null;
    }

    public final void removeAllMarks() {
        TTPdfReader r0 = this.pdfReader;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r0 = null;
    L5:
        r0.clearMarks();
    }

    public final void setToFirstPage() {
        scale(1.0f);
        if (Intrinsics.areEqual(this.showThumbnail.getValue(), Boolean.TRUE) == false) goto L5;
        this.showThumbnail.setValue(Boolean.FALSE);
    L5:
        TTPdfReader r0 = this.pdfReader;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r0 = null;
    L8:
        r0.getView().post(new f(this));
    }

    public final void toggleThumbnail() {
        Boolean r0 = (Boolean) this.showThumbnail.getValue();
        if (r0 == null) goto L5;
        boolean r1 = r0.booleanValue();
    L6:
        this.showThumbnail.setValue(Boolean.valueOf(!r1));
        return;
    L5:
        r1 = false;
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
    public final MutableLiveData<Integer> m372getPageCount() {
        return this.pageCount;
    }

    public static final /* synthetic */ com.bytedance.ee.bear.drive.view.preview.ttreader.a access$getClickHelper$p(PDFCtrlViewModel r0) {
        return r0.clickHelper;
    }

    public static final /* synthetic */ j0 access$getPdfOutline$p(PDFCtrlViewModel r0) {
        return r0.pdfOutline;
    }

    public static final /* synthetic */ TTPdfReader access$getPdfReader$p(PDFCtrlViewModel r0) {
        return r0.pdfReader;
    }

    public static final /* synthetic */ com.bytedance.ee.bear.drive.view.preview.wrapper.z access$getPreviewFileModel$p(PDFCtrlViewModel r0) {
        return r0.previewFileModel;
    }

    public static final /* synthetic */ PreviewViewModel access$getPreviewViewModel$p(PDFCtrlViewModel r0) {
        return r0.previewViewModel;
    }

    public static final /* synthetic */ c95.c access$getShowViewTrackEventCallback$p(PDFCtrlViewModel r0) {
        return r0.showViewTrackEventCallback;
    }

    public static final /* synthetic */ MutableLiveData access$getStructure$p(PDFCtrlViewModel r0) {
        return r0.structure;
    }

    public static final /* synthetic */ TitleBarViewModel access$getTitleBarViewModel$p(PDFCtrlViewModel r0) {
        return r0.titleBarViewModel;
    }

    public static final /* synthetic */ void access$readOutline(PDFCtrlViewModel r0) {
        r0.readOutline();
    }

    public final float getCurrentPageOffset(int r2) {
        TTPdfReader r0 = this.pdfReader;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r0 = null;
    L6:
        return r0.getCurrentPageOffset(r2);
    }

    public final SizeF getPageResolution(int r2) {
        TTPdfReader r0 = this.pdfReader;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r0 = null;
    L6:
        return r0.getPageResolution(r2);
    }

    public final SizeF getPageSizeF(int r4) {
        TTPdfReader r0 = this.pdfReader;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r0 = null;
    L5:
        if (r4 >= 0) goto L8;
        r4 = 0;
    L8:
        SizeF r5 = r0.getPageSize(r4);
        float r1 = 0.0f;
        if (r5 == null) goto L11;
        float r2 = r5.getWidth();
    L12:
        if (r5 == null) goto L15;
        r1 = r5.getHeight();
    L15:
        return new SizeF(r2, r1);
    L11:
        r2 = 0.0f;
        goto L12
    }

    public final void removeMark(String r2) {
        Intrinsics.checkNotNullParameter(r2, "markId");
        TTPdfReader r0 = this.pdfReader;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r0 = null;
    L5:
        r0.removeMark(r2);
    }

    public final void scale(float r4) {
        TTPdfReader r0 = this.pdfReader;
        TTPdfReader r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r0 = null;
    L6:
        if (r0.getScale() != r4) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return;
    L11:
        TTPdfReader r3 = this.pdfReader;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
    L15:
        r1.setScale(r4);
        return;
    L14:
        r1 = r3;
        goto L15
    L8:
        r2 = false;
        goto L9
    }

    @Override // da5.d
    public void scrollTo(String r3) {
        Intrinsics.checkNotNullParameter(r3, "contentId");
        if (this.pdfOutline != null) goto L5;
        return;
    L5:
        j0 r0 = this.pdfOutline;
        Intrinsics.checkNotNull(r0);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "hash");
        j0.b r4 = r0.b.get(r3);
        if (r4 == null) goto L14;
        int r5 = (int) r4.getPageIdx();
        tt5.a.h(TAG, "Click bookmark, pageIdx: " + r5);
        if (r5 < 0) goto L15;
        TTPdfReader r1 = this.pdfReader;
        if (r1 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r1 = null;
    L12:
        r1.turnTo(r5);
        return;
    L15:
        return;
    }

    @Override // da5.d
    public void setActive(String r1) {
        this.activeBookmarkId = r1;
    }

    public final void setTouchEvent(MotionEvent r2) {
        com.bytedance.ee.bear.drive.view.preview.ttreader.a r0 = this.clickHelper;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    public final void turnToPage(int r2) {
        TTPdfReader r0 = this.pdfReader;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r0 = null;
    L5:
        r0.turnTo(r2);
    }

    public final void updateClickTime(long r1) {
        this.lastClickTime = r1;
    }

    public static final /* synthetic */ void access$setLastClickTime$p(PDFCtrlViewModel r0, long r1) {
        r0.lastClickTime = r1;
    }

    public static final /* synthetic */ void access$setMShowMenu$p(PDFCtrlViewModel r0, boolean r1) {
        r0.mShowMenu = r1;
    }

    public static final /* synthetic */ void access$setPdfOutline$p(PDFCtrlViewModel r0, j0 r1) {
        r0.pdfOutline = r1;
    }

    @Override // da5.d
    public void changeCollapseStatus(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "hash");
        if (this.pdfOutline != null) goto L5;
        return;
    L5:
        j0 r1 = this.pdfOutline;
        Intrinsics.checkNotNull(r1);
        boolean r5 = !r4;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "hash");
        j0.b r6 = r1.b.get(r3);
        if (r6 == null) goto L8;
        r6.b = r5;
    L8:
        MutableLiveData<Structure> r7 = this.structure;
        j0 r8 = this.pdfOutline;
        Intrinsics.checkNotNull(r8);
        r8.getClass();
        ArrayList<Structure.Paragraph> r0 = new ArrayList();
        r8.a(r8.a, r0);
        Structure r9 = new Structure();
        r9.paragraphs = (Structure.Paragraph[]) r0.toArray(new Structure.Paragraph[0]);
        r7.setValue(r9);
    }

    public final void openPdf(String r19, a95.a r20) {
        Intrinsics.checkNotNullParameter(r20, "userComponentAbility");
        tt5.a.h(TAG, "openPdf() pwd empty=" + TextUtils.isEmpty(r19));
        c95.c r1 = this.showViewTrackEventCallback;
        if (r1 == null) goto L5;
        r1.onShowStart();
    L5:
        j65.a.b(this.previewViewModel, TAG);
        com.bytedance.ee.bear.drive.view.preview.wrapper.z r2 = this.previewFileModel;
        if (r2 == null) goto L15;
        LinkedHashMap<String, String> r3 = r2.f;
        if (r3 == null) goto L15;
        Set<Map.Entry<String, String>> r4 = r3.entrySet();
        if (r4 == null) goto L15;
        Iterator<Map.Entry<String, String>> r5 = r4.iterator();
        Uri r6 = null;
    L13:
        if (r5.hasNext() == false) goto L16;
        r6 = UriProtector.parse(r5.next().getValue());
    L16:
        com.bytedance.ee.bear.drive.view.preview.wrapper.z r7 = this.previewFileModel;
        if (r7 != null) goto L19;
    L21:
        boolean r8 = false;
    L22:
        if (r8 == false) goto L25;
        if (r6 == null) goto L25;
        tt5.a.h(TAG, "openPdf() by streaming...");
        Uri r13 = r6;
    L35:
        Application r9 = eu5.b.a;
        DriveFilePath r10 = com.bytedance.ee.bear.drive.cache.t.h();
        StringBuilder r11 = new StringBuilder();
        PreviewViewModel r12 = this.previewViewModel;
        if (r12 == null) goto L38;
        Integer r14 = Integer.valueOf(r12.getBizType());
    L39:
        r11.append(r14);
        r11.append('_');
        com.bytedance.ee.bear.drive.view.preview.wrapper.z r16 = this.previewFileModel;
        if (r16 == null) goto L42;
        String r17 = r16.o;
    L43:
        r11.append(r17);
        r11.append('_');
        com.bytedance.ee.bear.drive.view.preview.wrapper.z r18 = this.previewFileModel;
        if (r18 == null) goto L46;
        String r21 = r18.n;
    L47:
        r11.append(r21);
        r11.append(".pdf");
        r10.cacheName(r11.toString());
        StringBuilder r22 = new StringBuilder("openPdf, streamingFilePath: ");
        Intrinsics.checkNotNull(r10);
        String r23 = z75.b.b(r10, r20.b).getRealPath();
        if (r23 != null) goto L50;
        r23 = null;
    L50:
        r22.append(du5.b.f(r23));
        r22.append(", previewFileSize: ");
        com.bytedance.ee.bear.drive.view.preview.wrapper.z r24 = this.previewFileModel;
        if (r24 == null) goto L53;
        Long r26 = Long.valueOf(r24.k);
    L54:
        r22.append(r26);
        r22.append(", uri: ");
        r22.append(du5.b.g(r13.toString()));
        r22.append(", apiExtra: ");
        com.bytedance.ee.bear.drive.view.preview.wrapper.z r27 = this.previewFileModel;
        if (r27 == null) goto L57;
        String r28 = r27.s;
    L58:
        r22.append(r28);
        r22.append(", dataVersion: ");
        com.bytedance.ee.bear.drive.view.preview.wrapper.z r29 = this.previewFileModel;
        if (r29 == null) goto L61;
        String r30 = r29.n;
    L62:
        r22.append(r30);
        tt5.a.h(TAG, r22.toString());
        TTPdfReader r31 = this.pdfReader;
        if (r31 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        TTPdfReader r110 = null;
    L66:
        com.bytedance.ee.bear.drive.view.preview.wrapper.z r32 = this.previewFileModel;
        String r111 = "";
        if (r32 == null) goto L72;
        String r33 = r32.o;
        if (r33 == null) goto L72;
        String r34 = r33;
    L73:
        String r36 = r13.toString();
        com.bytedance.ee.bear.drive.view.preview.wrapper.z r37 = this.previewFileModel;
        if (r37 == null) goto L76;
        long r38 = r37.k;
    L77:
        if (r37 == null) goto L80;
        String r39 = r37.s;
        if (r39 == null) goto L80;
    L81:
        if (r37 == null) goto L84;
        String r40 = r37.n;
        if (r40 == null) goto L84;
    L85:
        if (r37 == null) goto L90;
        String r41 = r37.t;
        if (r41 == null) goto L90;
        String r42 = r41;
    L91:
        PreviewViewModel r43 = this.previewViewModel;
        if (r43 == null) goto L94;
        MutableLiveData<Object> r112 = r43.liveInnerSaveCache();
    L95:
        r110.setStreamingDownloader(new PDFStreamingDownloader(r34, r36, r10, r38, r39, r40, r42, r112, r20));
        com.bytedance.ee.bear.drive.view.preview.wrapper.z r44 = this.previewFileModel;
        if (r44 == null) goto L99;
        String r46 = r44.c;
        if (r46 == null) goto L99;
    L100:
        if (r44 == null) goto L106;
        String r47 = r44.b;
        if (r47 == null) goto L106;
        r111 = r47;
    L106:
        if (TextUtils.isEmpty(r46) == false) goto L109;
        r46 = r111;
    L109:
        TTPdfReader r48 = this.pdfReader;
        if (r48 != null) goto L112;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        TTPdfReader r113 = null;
    L113:
        r113.open(r13, r19, r46);
        return;
    L112:
        r113 = r48;
    L99:
        r46 = "";
        goto L100
    L94:
        r112 = null;
    L90:
        r42 = "";
    L84:
        r40 = "";
    L80:
        r39 = "";
        goto L81
    L76:
        r38 = 0;
    L72:
        r34 = "";
        goto L73
    L65:
        r110 = r31;
        goto L66
    L61:
        r30 = null;
        goto L62
    L57:
        r28 = null;
        goto L58
    L53:
        r26 = null;
        goto L54
    L46:
        r21 = null;
        goto L47
    L42:
        r17 = null;
        goto L43
    L38:
        r14 = null;
    L25:
        if (r7 == null) goto L28;
        DriveFilePath r49 = r7.d;
        if (r49 == null) goto L28;
    L29:
        VFSFile r50 = z75.b.e(r49, r20.b);
        tt5.a.h(TAG, "openPdf() by local file=" + r50 + " size=" + r50.length());
        Uri r51 = Uri.fromFile(r50);
        if (r50.isDirectory() == false) goto L32;
    L115:
        tt5.a.h(TAG, "file not found, try to reload, fileErrorReloadTime=" + this.fileErrorReloadTime);
        if (this.fileErrorReloadTime < 2) goto L118;
        return;
    L118:
        if (isInit() == false) goto L127;
        this.fileErrorReloadTime++;
        PreviewViewModel r52 = this.previewViewModel;
        if (r52 == null) goto L128;
        MutableLiveData<Void> r53 = r52.liveInnerReload();
        if (r53 == null) goto L129;
        r53.postValue(null);
        return;
    L129:
        return;
    L128:
        return;
    L127:
        return;
    L32:
        if (r49.isEmpty() == true) goto L115;
        r13 = r51;
    L28:
        DriveFilePath.Companion.getClass();
        r49 = DriveFilePath.a.a();
        goto L29
    L19:
        if (r7.i != true) goto L21;
        r8 = true;
    L15:
        r6 = null;
        goto L16
    }

    public final void scrollYOffset(int r2, int r3) {
        TTPdfReader r0 = this.pdfReader;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r0 = null;
    L5:
        r0.scrollY(r2, r3);
    }

    public final void updateAreaMarkColor(String r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "markId");
        TTPdfReader r0 = this.pdfReader;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r0 = null;
    L5:
        r0.updateAreaMarkStyle(r4, 8, r5, 0);
    }

    public final void updateContentMarkColor(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "markId");
        TTPdfReader r0 = this.pdfReader;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r0 = null;
    L5:
        r0.updateAreaMarkStyle(r3, 0, 0, r4);
    }

    public final PagePart getPageForPresentation(int r10, int r11, int r12) {
        TTPdfReader r2 = this.pdfReader;     // Catch: Throwable -> L11
        if (r2 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");     // Catch: Throwable -> L11
        r2 = null;
    L6:
        if (r10 < 0) goto L8;
        int r3 = r10;
    L9:
        return r2.loadPageSync(r3, r11 * 1.0f, r12 * 1.0f, new RectF(0.0f, 0.0f, 1.0f, 1.0f), false, true);
    L8:
        r3 = 0;
    L11:
        th = move-exception;
        tt5.a.f(TAG, th, false);
        return null;
    }

    public final void markArea(String r11, int r12, List<? extends RectF> r13, int r14, boolean r16, boolean r17) {
        Intrinsics.checkNotNullParameter(r11, "markId");
        Intrinsics.checkNotNullParameter(r13, "contentAreaRates");
        TTPdfReader r1 = this.pdfReader;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r1 = null;
    L5:
        r1.markAreas(r11, r12, r13, 8, r14, 0, r16, r17);
    }

    public final void markContent(String r11, int r12, List<? extends RectF> r13, int r14, boolean r16, boolean r17) {
        Intrinsics.checkNotNullParameter(r11, "markId");
        Intrinsics.checkNotNullParameter(r13, "contentAreaRates");
        TTPdfReader r1 = this.pdfReader;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pdfReader");
        r1 = null;
    L5:
        r1.markAreas(r11, r12, r13, 0, 0, r14, r16, r17);
    }

    public final void init(LifecycleOwner r2, TTPdfReader r3, com.bytedance.ee.bear.drive.view.preview.wrapper.z r4, PreviewViewModel r5, TitleBarViewModel r6, com.bytedance.ee.bear.drive.view.preview.wrapper.m r7, com.bytedance.ee.bear.drive.view.preview.ttreader.a r8, c95.c r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "pdfReader");
        Intrinsics.checkNotNullParameter(r7, "previewView");
        Intrinsics.checkNotNullParameter(r8, "clickHelper");
        this.pdfReader = r3;
        this.previewFileModel = r4;
        this.previewViewModel = r5;
        this.titleBarViewModel = r6;
        this.previewView = r7;
        this.clickHelper = r8;
        this.showViewTrackEventCallback = r9;
        this.lifecycleOwner = r2;
        r3.setMaxScale(o75.b.a().getDriveConfig().a().getPdfMaxScale());
        r3.setMinScale(o75.b.a().getDriveConfig().a().getPdfMinScale());
        if (r10 == false) goto L5;
        r3.setMaxScale(1.0f);
        r3.setMinScale(1.0f);
    L5:
        _init();
    }
}
