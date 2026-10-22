package com.bytedance.ee.bear.document.imageviewer.edit;

import android.content.Context;
import android.content.Intent;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.WebFragment;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.s;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.imageviewer.bean.ImageData;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.document.imageviewer.bean.EditImageData;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.imageviewer.edit.EditImageFragment;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.ui.j;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.photoeditor.impl.editaction.CropAndRotationAction;
import com.ss.android.lark.photoeditor.impl.ui.PhotoEditorActivity;
import com.ss.android.lark.ui.RotateLoadingView;
import com.ss.android.lark.vfs.VFSFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 02\u00020\u00012\u00020\u0002:\u000201B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u000f\u001a\u00020\u00102\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0013\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u0012H\u0016J\u001c\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\"\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020\u0010H\u0002J\u0010\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020\u00102\u0006\u0010*\u001a\u00020+H\u0002J\u0018\u0010-\u001a\u00020\u00132\u0006\u0010.\u001a\u00020\u00132\u0006\u0010/\u001a\u00020\u0013H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/bytedance/ee/bear/document/imageviewer/edit/EditImagePlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "Lcom/bytedance/ee/bear/facade/common/ActivityResultHandler;", "<init>", "()V", "editImageViewModel", "Lcom/bytedance/ee/bear/document/imageviewer/edit/EditImageViewModel;", "delayedExitFragmentTask", "Ljava/lang/Runnable;", "callbackFunction", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "editImage", "Lcom/bytedance/ee/bear/contract/imageviewer/api/IEditImage;", "editImageAnalytic", "Lcom/bytedance/ee/bear/document/imageviewer/edit/analytic/EditImageAnalytic;", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToUIContainer", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromHost", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "getCrop", "", "", JSEventListener.ACTION, "Lcom/ss/android/lark/photoeditor/impl/editaction/CropAndRotationAction;", "ensureFragment", "Lcom/bytedance/ee/bear/document/imageviewer/bean/EditImageData;", "exitFragment", "handleEditResult", TipCallBackData.RESULT, "Lcom/bytedance/ee/bear/document/imageviewer/edit/EditResult;", "callbackFun", "encodeUrl", "filePath", "uuid", "Companion", "EditImageHandler", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EditImagePlugin extends DocumentPluginV2 implements sa5.a {
    public static final a Companion = null;
    private static final long EDIT_IMAGE_FRAGMENT_CLOSE_DELAY_MS = 250;
    private static final String EDIT_RESULT_SUFFIX = "_edit";
    private static final int REQUEST_CODE = 771;
    private static final String TAG = "EditImagePlugin";
    private m callbackFunction;
    private final Runnable delayedExitFragmentTask;
    private sw4.a editImage;
    private u15.a editImageAnalytic;
    private final EditImageViewModel editImageViewModel;

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<EditImageData> {
        public final /* synthetic */ EditImagePlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(EditImagePlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r5, m r6) {
            EditImageData r7 = (EditImageData) r5;
            StringBuilder r0 = new StringBuilder("handle data == null : ");
            boolean r1 = false;
            if (r7 != null) goto L5;
            boolean r3 = true;
        L6:
            r0.append(r3);
            r0.append(", src: ");
            if (r7 == null) goto L9;
            String r4 = r7.getSrc();
        L10:
            if (r4 != null) goto L12;
        L13:
            r1 = true;
        L14:
            r0.append(r1);
            Log.i(EditImagePlugin.TAG, r0.toString());
            EditImagePlugin.access$getEditImageViewModel$p(this.a).updateEditImageData(r7);
            EditImagePlugin.access$setCallbackFunction$p(this.a, r6);
            return;
        L12:
            if (r4.length() != 0) goto L14;
        L9:
            r4 = null;
            goto L10
        L5:
            r3 = false;
            goto L6
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ EditImagePlugin a;

        public c(EditImagePlugin r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            EditImagePlugin.access$exitFragment(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements uw4.e {
        public final /* synthetic */ EditImagePlugin a;

        public d(EditImagePlugin r1) {
            this.a = r1;
        }

        @Override // uw4.e
        public final void close() {
            EditImagePlugin.access$getEditImageViewModel$p(this.a).clear();
            EditImagePlugin.access$exitFragment(this.a);
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ EditImagePlugin a;

        public e(EditImagePlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            EditImageData r6 = (EditImageData) r5;
            if (r6 != null) goto L5;
            Log.e(EditImagePlugin.TAG, "get EditImageData null!!!");
            return;
        L5:
            u15.a r1 = EditImagePlugin.access$getEditImageAnalytic$p(this.a);
            if (r1 == null) goto L14;
            ImageData.Image r2 = r6.getImage();
            if (r2 == null) goto L11;
            String r3 = r2.getSrcObjToken();
            if (r3 == null) goto L11;
        L12:
            r1.a("pic_edit_entrance", r3);
        L11:
            r3 = "";
        L14:
            if (com.bytedance.ee.util.ui.b.a(EditImagePlugin.access$getActivity(this.a)) == true) goto L16;
        L18:
            Log.e(EditImagePlugin.TAG, "getEditImageData err! activity is not Active or url empty");
            return;
        L16:
            if (EditImagePlugin.access$isUIContainerAttached(this.a) == false) goto L18;
            EditImagePlugin.access$ensureFragment(this.a, r6);
        }
    }

    public static final class f implements EditImageViewModel.b {
        public final /* synthetic */ EditImagePlugin a;

        public f(EditImagePlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.imageviewer.edit.EditImageViewModel.b
        public final void a(String r12) {
            if (r12 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == false) goto L26;
            Log.e(EditImagePlugin.TAG, "editImg err: path empty");
            sw4.a r13 = EditImagePlugin.access$getEditImage$p(this.a);
            if (r13 == null) goto L41;
            final EditImageFragment r14 = (EditImageFragment) r13;
            olb.a r2 = r14.e;
            if (r2 == null) goto L15;
            r2.a();
        L15:
            FrameLayout r3 = r14.f;
            if (r3 == null) goto L20;
            View r4 = r3.getChildAt(0);
            if ((r4 instanceof RotateLoadingView) == false) goto L20;
            r14.f.removeView(r4);
        L20:
            RelativeLayout r5 = r14.h;
            if (r5 == null) goto L42;
            r5.setVisibility(0);
            AppCompatImageView r0 = r14.g;
            if (r0 == null) goto L43;
            r0.setOnClickListener(new com.bytedance.ee.bear.imageviewer.edit.a(r14));
            return;
        L43:
            return;
        L42:
            return;
        L41:
            return;
        L26:
            int r6 = StringsKt.lastIndexOf$default(r12, ".", 0, false, 6, null);
            PluginHost r7 = this.a.getHost();
            WebFragment r8 = null;
            if ((r7 instanceof DocumentPluginHost) == false) goto L29;
            DocumentPluginHost r9 = (DocumentPluginHost) r7;
        L30:
            if (r9 == null) goto L32;
            r8 = r9.c();
        L32:
            String r10 = r12.subSequence(0, r6) + EditImagePlugin.EDIT_RESULT_SUFFIX + r12.substring(r6, r12.length());
            if (r8 == null) goto L39;
            FragmentActivity r11 = EditImagePlugin.access$getActivity(this.a);
            Bundle r16 = p0c.b.a(r12, r10, "from_doc_preview", "", null, null);
            if (r8.isAdded() == false) goto L38;
            Intent r17 = new Intent(r11, PhotoEditorActivity.class);
            r17.putExtras(r16);
            r8.startActivityForResult(r17, EditImagePlugin.REQUEST_CODE);
        L38:
            j.e(EditImagePlugin.access$getDelayedExitFragmentTask$p(this.a));
            j.d(EditImagePlugin.access$getDelayedExitFragmentTask$p(this.a), EditImagePlugin.EDIT_IMAGE_FRAGMENT_CLOSE_DELAY_MS);
            return;
        L39:
            EditImagePlugin.access$exitFragment(this.a);
            return;
        L29:
            r9 = null;
            goto L30
        L5:
            if (r12.length() == 0) goto L8;
            r1 = false;
            goto L9
        }

        @Override // com.bytedance.ee.bear.document.imageviewer.edit.EditImageViewModel.b
        public final void c(t15.a r2) {
            Intrinsics.checkNotNullParameter(r2, TipCallBackData.RESULT);
            EditImagePlugin.access$callbackFun(this.a, r2);
        }

        @Override // com.bytedance.ee.bear.document.imageviewer.edit.EditImageViewModel.b
        public final String b(String r9, ImageData.Image r10) {
            Intrinsics.checkNotNullParameter(r9, "url");
            Intrinsics.checkNotNullParameter(r10, "image");
            DocViewModel r0 = EditImagePlugin.access$getDocViewModel(this.a);
            if (r0 != null) goto L7;
            return "";
        L7:
            return ((sw4.b) org.koin.java.a.c(sw4.b.class, null, null, 6)).e(EditImagePlugin.access$getActivity(this.a), r9, r0.getToken(), r0.getDocumentTypeValue(), r10);
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void exitFragment() {
        j.e(this.delayedExitFragmentTask);
        sw4.a r0 = this.editImage;
        FragmentManager r1 = null;
        if (r0 == null) goto L5;
        ((EditImageFragment) r0).i = null;
    L5:
        sw4.b r2 = (sw4.b) org.koin.java.a.c(sw4.b.class, null, null, 6);
        t r3 = getUIContainer();
        if (r3 == null) goto L8;
        r1 = r3.getFragmentManager();
    L8:
        r2.a(r1);
    }

    public EditImagePlugin() {
        this.editImageViewModel = new EditImageViewModel();
        this.delayedExitFragmentTask = new c(this);
    }

    public static final /* synthetic */ void access$exitFragment(EditImagePlugin r0) {
        r0.exitFragment();
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(EditImagePlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ Runnable access$getDelayedExitFragmentTask$p(EditImagePlugin r0) {
        return r0.delayedExitFragmentTask;
    }

    public static final /* synthetic */ DocViewModel access$getDocViewModel(EditImagePlugin r0) {
        return r0.getDocViewModel();
    }

    public static final /* synthetic */ sw4.a access$getEditImage$p(EditImagePlugin r0) {
        return r0.editImage;
    }

    public static final /* synthetic */ u15.a access$getEditImageAnalytic$p(EditImagePlugin r0) {
        return r0.editImageAnalytic;
    }

    public static final /* synthetic */ EditImageViewModel access$getEditImageViewModel$p(EditImagePlugin r0) {
        return r0.editImageViewModel;
    }

    public static final /* synthetic */ boolean access$isUIContainerAttached(EditImagePlugin r0) {
        return r0.isUIContainerAttached();
    }

    private final void callbackFun(t15.a r7) {
        JSONArray r0 = new JSONArray();
        JSONObject r1 = new JSONObject();
        r1.put("contentType", "image/jpeg");
        r1.put("uuid", UUID.randomUUID().toString());
        r1.put("src", encodeUrl(r7.b, r7.a));
        r1.put("width", Integer.valueOf(r7.c));
        r1.put("height", Integer.valueOf(r7.d));
        r1.put("duration", 0);
        r1.put("crop", r7.e);
        r1.put("angle", Integer.valueOf(r7.f));
        VFSFile r8 = ay4.d.a().i(r7.b);
        if (r8.exists() == false) goto L5;
        r1.put("fileSize", Long.valueOf(r8.length()));
        r1.put("fileName", r8.getName());
    L5:
        r0.add(r1);
        JSONObject r9 = new JSONObject();
        r9.put("code", 0);
        r9.put("thumbs", r0);
        Log.d(TAG, "buildJsonData: " + du5.b.k(r9.toString()));
        m r2 = this.callbackFunction;
        if (r2 == null) goto L9;
        r2.b(r9);
        return;
    }

    private final void ensureFragment(EditImageData r8) {
        BaseUnspecifiedOrientationPlugin r0 = (BaseUnspecifiedOrientationPlugin) findPlugin(BaseUnspecifiedOrientationPlugin.class);
        if (ForsetiHelper.s(getHost().getHostFragment()) == true) goto L6;
        if (r0 == null) goto L6;
        r0.forcePortrait();
    L6:
        String r1 = r8.getSrc();
        ImageData.Image r9 = r8.getImage();
        if (r1 != null) goto L9;
    L12:
        boolean r2 = true;
    L13:
        if (r2 == true) goto L27;
        if (r9 == null) goto L29;
        s r3 = s.a(2130772329, 2130772330, 2130772329, 2130772330);
        ViewGroup r4 = null;
        sw4.b r5 = (sw4.b) org.koin.java.a.c(sw4.b.class, null, null, 6);
        Context r6 = getContext();
        t r7 = getUIContainer();
        if (r7 == null) goto L19;
        FragmentManager r10 = r7.getFragmentManager();
    L20:
        t r11 = getUIContainer();
        if (r11 == null) goto L23;
        r4 = r11.c(this);
    L23:
        this.editImage = r5.h(r6, r10, r3, r4);
        this.editImageViewModel.getPathFromUrl(r1, r9);
        sw4.a r12 = this.editImage;
        if (r12 == null) goto L28;
        ((EditImageFragment) r12).i = new d(this);
        return;
    L28:
        return;
    L19:
        r10 = null;
        goto L20
    L29:
        return;
    L27:
        return;
    L9:
        if (r1.length() == 0) goto L12;
        r2 = false;
        goto L13
    }

    private final List<Float> getCrop(CropAndRotationAction r14) {
        RectF r0 = r14.b;
        RectF r16 = r14.c;
        if (r0 == null) goto L9;
        if (r16 == null) goto L9;
        StringCompanionObject r8 = StringCompanionObject.INSTANCE;
        Locale r9 = Locale.US;
        return CollectionsKt.arrayListOf(new Float[]{Float.valueOf(CastFloatProtector.parseFloat(String.format(r9, "%.4f", Arrays.copyOf(new Object[]{Float.valueOf(RangesKt.coerceIn((r16.left - r0.left) / r0.width(), 0.0f, 1.0f))}, 1)))), Float.valueOf(CastFloatProtector.parseFloat(String.format(r9, "%.4f", Arrays.copyOf(new Object[]{Float.valueOf(RangesKt.coerceIn((r16.top - r0.top) / r0.height(), 0.0f, 1.0f))}, 1)))), Float.valueOf(CastFloatProtector.parseFloat(String.format(r9, "%.4f", Arrays.copyOf(new Object[]{Float.valueOf(RangesKt.coerceIn((r16.right - r0.left) / r0.width(), 0.0f, 1.0f))}, 1)))), Float.valueOf(CastFloatProtector.parseFloat(String.format(r9, "%.4f", Arrays.copyOf(new Object[]{Float.valueOf(RangesKt.coerceIn((r16.bottom - r0.top) / r0.height(), 0.0f, 1.0f))}, 1))))});
    L9:
        return CollectionsKt.arrayListOf(new Float[]{Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(1.0f), Float.valueOf(1.0f)});
    }

    private final void handleEditResult(t15.a r6) {
        DocViewModel r0 = getDocViewModel();
        if (r0 == null) goto L5;
        this.editImageViewModel.saveFile(r0.getToken(), r0.getUrl(), encodeUrl(r6.b, r6.a), r6);
    L5:
        EditImageData r7 = (EditImageData) this.editImageViewModel.getEditImageData().getValue();
        if (r7 == null) goto L11;
        ImageData.Image r8 = r7.getImage();
        if (r8 == null) goto L11;
        String r9 = r8.getSrcObjToken();
        if (r9 == null) goto L11;
    L12:
        u15.a r1 = this.editImageAnalytic;
        if (r1 == null) goto L16;
        r1.a("pic_edit_finish", r9);
        return;
    L16:
        return;
    L11:
        r9 = "";
        goto L12
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put("biz.util.editImg", new b(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromHost(PluginHost r2) {
        j.e(this.delayedExitFragmentTask);
        super.onDetachFromHost(r2);
        this.editImageViewModel.clear();
    }

    public static final /* synthetic */ void access$callbackFun(EditImagePlugin r0, t15.a r1) {
        r0.callbackFun(r1);
    }

    public static final /* synthetic */ void access$ensureFragment(EditImagePlugin r0, EditImageData r1) {
        r0.ensureFragment(r1);
    }

    public static final /* synthetic */ void access$setCallbackFunction$p(EditImagePlugin r0, m r1) {
        r0.callbackFunction = r1;
    }

    private final String encodeUrl(String r9, String r10) {
        return "docsource://com.bytedance.net/file/f/" + r10 + r9.substring(StringsKt.lastIndexOf$default(r9, ".", 0, false, 6, null));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(PluginHost r3, t r4) {
        super.onAttachToUIContainer(r3, r4);
        this.editImageAnalytic = new u15.a((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6));
        this.editImageViewModel.getEditImageData().observe(getLifecycleOwner(), new e(this));
        this.editImageViewModel.setCallback(new f(this));
    }

    @Override // sa5.a
    public void onActivityResult(int r12, int r13, Intent r14) {
        StringBuilder r0 = new StringBuilder("onActivityResult: ");
        if (r14 != null) goto L5;
        boolean r3 = true;
    L6:
        r0.append(r3);
        Log.i(TAG, r0.toString());
        if (r14 != null) goto L10;
        return;
    L10:
        if (r13 == (-1)) goto L12;
        return;
    L12:
        if (r12 != REQUEST_CODE) goto L34;
        String r16 = r14.getStringExtra("key_result_path");
        if (r16 != null) goto L16;
        r16 = "";
    L16:
        String r6 = r16;
        int r7 = r14.getIntExtra("key_editor_width", 0);
        int r8 = r14.getIntExtra("key_editor_height", 0);
        ArrayList r17 = r14.getParcelableArrayListExtra("key_edit_action_list");
        StringBuilder r18 = new StringBuilder("onActivityResult actions size: ");
        CropAndRotationAction r19 = null;
        if (r17 == null) goto L19;
        Integer r1 = Integer.valueOf(r17.size());
    L20:
        r18.append(r1);
        Log.i(TAG, r18.toString());
        if (TextUtils.isEmpty(r6) == true) goto L31;
        if (r17 == null) goto L24;
        Parcelable r110 = (Parcelable) CollectionsKt.lastOrNull(r17);
    L26:
        if ((r110 instanceof CropAndRotationAction) == false) goto L28;
        r19 = (CropAndRotationAction) r110;
    L28:
        if (r19 == null) goto L30;
        handleEditResult(new t15.a(UUID.randomUUID().toString(), r6, r7, r8, getCrop(r19), r19.a));
        return;
    L30:
        handleEditResult(new t15.a(UUID.randomUUID().toString(), r6, r7, r8, CollectionsKt.arrayListOf(new Float[]{Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(1.0f), Float.valueOf(1.0f)}), 0));
        return;
    L24:
        r110 = null;
        goto L26
    L31:
        Log.e(TAG, "onActivityResult path null isEmpty!!!");
        return;
    L19:
        r1 = null;
        goto L20
    L34:
        return;
    L5:
        r3 = false;
        goto L6
    }
}
