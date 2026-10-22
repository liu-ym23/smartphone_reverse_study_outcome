package com.bytedance.ee.bear.document.toolbar.media;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSONObject;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
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

/* JADX INFO: loaded from: classes16.dex */
public class SelectMediaPlugin extends DocumentPluginV2 {
    private static final String TAG = "SelectMediaPlugin";
    private CompositeDisposable mCompositeDisposable;
    private m selectMediaCallback;
    private final i45.c selectMediaModule;

    public class a implements i45.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SelectMediaPlugin f222338a;

        @Override // i45.a
        public final boolean b() {
            y3 r100 = this.f222338a.getDocumentMetadata();
            if (e.f541296g.getType().equals(r100.getBearUrl().f222560a) == false) goto L5;
        L8:
            return true;
        L5:
            if (e.f541304o.getType().equals(r100.getBearUrl().f222560a) == true) goto L8;
            return false;
        }

        @Override // i45.a
        public FragmentActivity getActivity() {
            return this.f222338a.getHost().getActivity();
        }

        public a(SelectMediaPlugin r100) {
            this.f222338a = r100;
        }

        @Override // i45.a
        public final Disposable a(List<SelectedMediaItem> r100) {
            if (SelectMediaPlugin.access$000(this.f222338a) != null) goto L6;
            tt5.a.d("SelectMediaPlugin", "insertMedias(): failed cause selectMediaCallback is null ");
            return null;
        L6:
            SelectMediaPlugin r101 = this.f222338a;
            return r101.doInsertMediasInternal(r100, SelectMediaPlugin.access$000(r101), false);
        }

        @Override // i45.a
        public final void c(JSONObject r100) {
            this.f222338a.getBridge().a("window.lark.biz.util.cancelFromImageSelector", r100, null);
        }
    }

    public class b implements i<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SelectMediaPlugin f222339a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(SelectMediaPlugin r100) {
            this.f222339a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            Void r102 = (Void) r100;
            SelectMediaPlugin.access$002(this.f222339a, r101);
        }
    }

    public class c implements i<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SelectMediaPlugin f222340a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(SelectMediaPlugin r100) {
            this.f222340a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            Void r102 = (Void) r100;
            SelectMediaPlugin.access$002(this.f222340a, r101);
        }
    }

    public class d implements i<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SelectMediaPlugin f222341a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public d(SelectMediaPlugin r100) {
            this.f222341a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, final m r101) {
            String r102 = (String) r100;
            tt5.a.h("SelectMediaPlugin", "SrcToSelectImageHandler handle... data is null ? " + TextUtils.isEmpty(r102));
            JSONArray r103 = JSONObjectProtectorUtils.getJSONArray(new org.json.JSONObject(r102), "videoLocalPaths");     // Catch: Throwable -> L9
            tt5.a.h("SelectMediaPlugin", "SrcToSelectImageHandler... size is " + r103.length());     // Catch: Throwable -> L9
            ArrayList r104 = new ArrayList();     // Catch: Throwable -> L9
            int r105 = 0;
        L5:
            if (r105 >= r103.length()) goto L7;
            r104.add(JSONArrayProtectorUtils.getString(r103, r105));     // Catch: Throwable -> L9
            r105 = r105 + 1;     // Catch: Throwable -> L9
            goto L5
        L7:
            SelectMediaPlugin.access$400(this.f222341a).add(Flowable.fromIterable(r104).flatMap(new g(this)).toList().subscribe(new h(this, r101), new i45.i(this, r101)));     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            tt5.a.e("SelectMediaPlugin", "SrcToSelectImageHandler handle...", th, false);
        }
    }

    public static /* synthetic */ Publisher a(SelectMediaPlugin r100, List r101, List r102) {
        return r100.lambda$doInsertMediasInternal$0(r101, r102);
    }

    public static /* synthetic */ void c(SelectMediaPlugin r100, m r101, List r102, Boolean r103) {
        r100.lambda$doInsertMediasInternal$1(r101, r102, r103);
    }

    public static /* synthetic */ void d(SelectMediaPlugin r100, boolean r101, m r102, Throwable r103) {
        r100.lambda$doInsertMediasInternal$2(r101, r102, r103);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    private JSONObject buildFailedJsonData() {
        JSONObject r100 = new JSONObject();
        r100.put2("code", -1);
        return r100;
    }

    public SelectMediaPlugin() {
        this.mCompositeDisposable = new CompositeDisposable();
        this.selectMediaModule = new i45.c(new a(this));
    }

    public static /* synthetic */ m access$000(SelectMediaPlugin r100) {
        return r100.selectMediaCallback;
    }

    public static /* synthetic */ CompositeDisposable access$400(SelectMediaPlugin r100) {
        return r100.mCompositeDisposable;
    }

    public static /* synthetic */ JSONObject access$500(SelectMediaPlugin r100) {
        return r100.buildFailedJsonData();
    }

    private JSONObject buildJsonData(List<SelectedMediaItem> r100) {
        com.alibaba.fastjson.JSONArray r101 = new com.alibaba.fastjson.JSONArray();
        Iterator<SelectedMediaItem> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        SelectedMediaItem r103 = r102.next();
        JSONObject r104 = new JSONObject();
        r104.put2("contentType", r103.getContentType());
        r104.put2(ST.UUID_DEVICE, r103.getUuid());
        r104.put2("src", encodeUrl(r103));
        r104.put2("width", Integer.valueOf(r103.getWidth()));
        r104.put2("height", Integer.valueOf(r103.getHeight()));
        r104.put2("duration", Long.valueOf(r103.getDuration()));
        r104.put2("fileSize", Long.valueOf(r103.getFileSize()));
        r104.put2("fileName", r103.getFileName());
        r101.add(r104);
        goto L4
    L6:
        JSONObject r105 = new JSONObject();
        r105.put2("code", 0);
        r105.put2("thumbs", r101);
        tt5.a.b("SelectMediaPlugin", "buildJsonData: " + r105);
        return r105;
    }

    private String encodeUrl(SelectedMediaItem r100) {
        String r101 = r100.getMediaFile();
        return "docsource://com.bytedance.net/file/f/" + r100.getUuid() + r101.substring(r101.lastIndexOf("."));
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r100) {
        r100.put("biz.util.selectMedia", new c(this));
        r100.put("biz.util.selectImage", new b(this));
        r100.put("biz.util.getLocalMedia", new d(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromHost(PluginHost r100) {
        super.onDetachFromHost(r100);
        this.mCompositeDisposable.clear();
    }

    public static /* synthetic */ m access$002(SelectMediaPlugin r100, m r101) {
        r100.selectMediaCallback = r101;
        return r101;
    }

    private /* synthetic */ Publisher lambda$doInsertMediasInternal$0(List r100, List r101) throws Exception {
        HashMap r102 = new HashMap();
        Iterator r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L7;
        SelectedMediaItem r104 = (SelectedMediaItem) r103.next();
        r102.put(encodeUrl(r104), r104.getMediaFile());
        goto L4
    L7:
        return t.a(getDocumentMetadata().getUrl(), r102, false, null);
    }

    private SelectedMediaItem photo2MediaItems(String r110, Photo r111) {
        String r100 = UUID.randomUUID().toString();
        int r101 = r111.getWidth();
        int r102 = r111.getHeight();
        return new SelectedMediaItem(r111.getMimeType(), r100, r110, r101, r102, r111.getDuration(), r111.getSize(), VFSFiles.f444819b.i(r110).getName());
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(PluginHost r100, com.bytedance.ee.bear.browser.plugin.t r101) {
        super.onAttachToUIContainer(r100, r101);
        this.selectMediaModule.f488218b.a();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromUIContainer(PluginHost r100, com.bytedance.ee.bear.browser.plugin.t r101) {
        super.onDetachFromUIContainer(r100, r101);
        this.selectMediaModule.f488218b.b();
    }

    public static /* synthetic */ SelectedMediaItem access$600(SelectMediaPlugin r100, String r101, Photo r102) {
        return r100.photo2MediaItems(r101, r102);
    }

    private /* synthetic */ void lambda$doInsertMediasInternal$1(m r100, List r101, Boolean r102) throws Exception {
        r100.b(buildJsonData(r101));
    }

    private void lambda$doInsertMediasInternal$2(boolean r100, m r101, Throwable r102) throws Exception {
        tt5.a.e("SelectMediaPlugin", "doInsertMedias", r102, false);
        if (r100 == false) goto L6;
        r101.b(buildFailedJsonData());
        return;
    }

    public Disposable doInsertMediasInternal(final List<SelectedMediaItem> r100, final m r101, final boolean r102) {
        return Flowable.just(r100).flatMap(new i45.d(this, r100)).subscribeOn(fo5.d.a()).observeOn(fo5.d.d()).subscribe(new i45.e(this, r101, r100), new f(this, r102, r101));
    }
}
