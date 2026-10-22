package com.bytedance.ee.bear.document.toolbar.media;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.toolbar.media.impl.SelectedMediaItem;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.widget.photopicker.entity.Photo;
import i45.f;
import i45.g;
import i45.h;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import j25.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.reactivestreams.Publisher;
import sbb.e;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SelectMediaPlugin extends DocumentPluginV2 {
    private static final String TAG = "SelectMediaPlugin";
    private CompositeDisposable mCompositeDisposable;
    private m selectMediaCallback;
    private final i45.c selectMediaModule;

    public class a implements i45.a {
        public final /* synthetic */ SelectMediaPlugin a;

        @Override // i45.a
        public final boolean b() {
            y3 r0 = this.a.getDocumentMetadata();
            if (e.g.getType().equals(r0.getBearUrl().a) == false) goto L5;
        L8:
            return true;
        L5:
            if (e.o.getType().equals(r0.getBearUrl().a) == true) goto L8;
            return false;
        }

        @Override // i45.a
        public FragmentActivity getActivity() {
            return this.a.getHost().getActivity();
        }

        public a(SelectMediaPlugin r1) {
            this.a = r1;
        }

        @Override // i45.a
        public final Disposable a(List<SelectedMediaItem> r4) {
            if (SelectMediaPlugin.access$000(this.a) != null) goto L6;
            tt5.a.d(SelectMediaPlugin.TAG, "insertMedias(): failed cause selectMediaCallback is null ");
            return null;
        L6:
            SelectMediaPlugin r0 = this.a;
            return r0.doInsertMediasInternal(r4, SelectMediaPlugin.access$000(r0), false);
        }

        @Override // i45.a
        public final void c(JSONObject r4) {
            this.a.getBridge().a("window.lark.biz.util.cancelFromImageSelector", r4, null);
        }
    }

    public class b implements i<Void> {
        public final /* synthetic */ SelectMediaPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(SelectMediaPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            Void r3 = (Void) r1;
            SelectMediaPlugin.access$002(this.a, r2);
        }
    }

    public class c implements i<Void> {
        public final /* synthetic */ SelectMediaPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(SelectMediaPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            Void r3 = (Void) r1;
            SelectMediaPlugin.access$002(this.a, r2);
        }
    }

    public class d implements i<String> {
        public final /* synthetic */ SelectMediaPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public d(SelectMediaPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r6, final m r7) {
            String r8 = (String) r6;
            tt5.a.h(SelectMediaPlugin.TAG, "SrcToSelectImageHandler handle... data is null ? " + TextUtils.isEmpty(r8));
            JSONArray r9 = JSONObjectProtectorUtils.getJSONArray(new org.json.JSONObject(r8), "videoLocalPaths");     // Catch: Throwable -> L9
            tt5.a.h(SelectMediaPlugin.TAG, "SrcToSelectImageHandler... size is " + r9.length());     // Catch: Throwable -> L9
            ArrayList r0 = new ArrayList();     // Catch: Throwable -> L9
            int r3 = 0;
        L5:
            if (r3 >= r9.length()) goto L7;
            r0.add(JSONArrayProtectorUtils.getString(r9, r3));     // Catch: Throwable -> L9
            r3 = r3 + 1;     // Catch: Throwable -> L9
            goto L5
        L7:
            SelectMediaPlugin.access$400(this.a).add(Flowable.fromIterable(r0).flatMap(new g(this)).toList().subscribe(new h(this, r7), new i45.i(this, r7)));     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            tt5.a.e(SelectMediaPlugin.TAG, "SrcToSelectImageHandler handle...", th, false);
        }
    }

    public static /* synthetic */ Publisher a(SelectMediaPlugin r0, List r1, List r2) {
        return r0.lambda$doInsertMediasInternal$0(r1, r2);
    }

    public static /* synthetic */ void c(SelectMediaPlugin r0, m r1, List r2, Boolean r3) {
        r0.lambda$doInsertMediasInternal$1(r1, r2, r3);
    }

    public static /* synthetic */ void d(SelectMediaPlugin r0, boolean r1, m r2, Throwable r3) {
        r0.lambda$doInsertMediasInternal$2(r1, r2, r3);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private JSONObject buildFailedJsonData() {
        JSONObject r0 = new JSONObject();
        r0.put("code", -1);
        return r0;
    }

    public SelectMediaPlugin() {
        this.mCompositeDisposable = new CompositeDisposable();
        this.selectMediaModule = new i45.c(new a(this));
    }

    public static /* synthetic */ m access$000(SelectMediaPlugin r0) {
        return r0.selectMediaCallback;
    }

    public static /* synthetic */ CompositeDisposable access$400(SelectMediaPlugin r0) {
        return r0.mCompositeDisposable;
    }

    public static /* synthetic */ JSONObject access$500(SelectMediaPlugin r0) {
        return r0.buildFailedJsonData();
    }

    private JSONObject buildJsonData(List<SelectedMediaItem> r6) {
        com.alibaba.fastjson.JSONArray r0 = new com.alibaba.fastjson.JSONArray();
        Iterator<SelectedMediaItem> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        SelectedMediaItem r1 = r7.next();
        JSONObject r2 = new JSONObject();
        r2.put("contentType", r1.getContentType());
        r2.put("uuid", r1.getUuid());
        r2.put("src", encodeUrl(r1));
        r2.put("width", Integer.valueOf(r1.getWidth()));
        r2.put("height", Integer.valueOf(r1.getHeight()));
        r2.put("duration", Long.valueOf(r1.getDuration()));
        r2.put("fileSize", Long.valueOf(r1.getFileSize()));
        r2.put("fileName", r1.getFileName());
        r0.add(r2);
        goto L4
    L6:
        JSONObject r8 = new JSONObject();
        r8.put("code", 0);
        r8.put("thumbs", r0);
        tt5.a.b(TAG, "buildJsonData: " + r8);
        return r8;
    }

    private String encodeUrl(SelectedMediaItem r4) {
        String r0 = r4.getMediaFile();
        return "docsource://com.bytedance.net/file/f/" + r4.getUuid() + r0.substring(r0.lastIndexOf("."));
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        r3.put("biz.util.selectMedia", new c(this));
        r3.put("biz.util.selectImage", new b(this));
        r3.put("biz.util.getLocalMedia", new d(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromHost(PluginHost r1) {
        super.onDetachFromHost(r1);
        this.mCompositeDisposable.clear();
    }

    public static /* synthetic */ m access$002(SelectMediaPlugin r0, m r1) {
        r0.selectMediaCallback = r1;
        return r1;
    }

    private /* synthetic */ Publisher lambda$doInsertMediasInternal$0(List r3, List r4) throws Exception {
        HashMap r5 = new HashMap();
        Iterator r6 = r3.iterator();
    L4:
        if (r6.hasNext() == false) goto L7;
        SelectedMediaItem r0 = (SelectedMediaItem) r6.next();
        r5.put(encodeUrl(r0), r0.getMediaFile());
        goto L4
    L7:
        return t.a(getDocumentMetadata().getUrl(), r5, false, null);
    }

    private SelectedMediaItem photo2MediaItems(String r13, Photo r14) {
        String r3 = UUID.randomUUID().toString();
        int r5 = r14.getWidth();
        int r6 = r14.getHeight();
        return new SelectedMediaItem(r14.getMimeType(), r3, r13, r5, r6, r14.getDuration(), r14.getSize(), VFSFiles.b.i(r13).getName());
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        super.onAttachToUIContainer(r1, r2);
        this.selectMediaModule.b.a();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        super.onDetachFromUIContainer(r1, r2);
        this.selectMediaModule.b.b();
    }

    public static /* synthetic */ SelectedMediaItem access$600(SelectMediaPlugin r0, String r1, Photo r2) {
        return r0.photo2MediaItems(r1, r2);
    }

    private /* synthetic */ void lambda$doInsertMediasInternal$1(m r1, List r2, Boolean r3) throws Exception {
        r1.b(buildJsonData(r2));
    }

    private void lambda$doInsertMediasInternal$2(boolean r4, m r5, Throwable r6) throws Exception {
        tt5.a.e(TAG, "doInsertMedias", r6, false);
        if (r4 == false) goto L6;
        r5.b(buildFailedJsonData());
        return;
    }

    public Disposable doInsertMediasInternal(final List<SelectedMediaItem> r3, final m r4, final boolean r5) {
        return Flowable.just(r3).flatMap(new i45.d(this, r3)).subscribeOn(fo5.d.a()).observeOn(fo5.d.d()).subscribe(new i45.e(this, r4, r3), new f(this, r5, r4));
    }
}
