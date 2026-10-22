package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image;

import androidx.fragment.app.FragmentActivity;
import com.baidu.platform.comapi.map.MapController;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.thread.ThreadUtils;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chat.base.view.vo.message.ImageContentVO;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ImageContentBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.m;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.ChatImageErrDetector;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.utils.g;
import com.ss.android.lark.chat.utils.v;
import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.image.entity.ListenerParams;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.mark.MarkView;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import okio.ByteString;
import u2b.j;

/* JADX INFO: loaded from: classes35.dex */
public final class ImageCellLoader {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f412190e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m2b.a f412191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f412192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f412193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f412194d;

    public static final class a {
        @JvmStatic
        public static ImageSet a(ImageContentVO r100) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            return new ImageSet((String) r100.f411901h.getValue(), (Image) r100.f411902i.getValue(), (Image) r100.f411904k.getValue(), (Image) r100.f411905l.getValue(), (ByteString) r100.f411906m.getValue(), r100.f411907n);
        }

        @JvmStatic
        public static Image b(ImageContentVO r100) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            return g.b(a(r100));
        }
    }

    public static final class b implements ListenerParams.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m2b.a f412195a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c f412196b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image.a f412197c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f412198d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f412199e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final v f412200f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Lazy f412201g;

        @Override // com.ss.android.lark.image.entity.ListenerParams.b
        public final void a(Exception r110) {
            Log.e("ImageCellLoader", "image load failed, messageId=" + this.f412198d + ", imageKey=" + this.f412199e, r110);
            ChatImageErrDetector r111 = (ChatImageErrDetector) this.f412201g.getValue();
            String r100 = this.f412198d;
            String r101 = this.f412199e;
            r111.getClass();
            Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
            if (r101 == null) goto L6;
            ((ConcurrentHashMap) ChatImageErrDetector.f413592a).put(new ChatImageErrDetector.b(r100, r101), Boolean.FALSE);
            ChatImageErrDetector.f413593b.put(new ChatImageErrDetector.b(r100, r101), AppreciableKit.Companion.getInstance().start(Biz.Messenger, Scene.Chat, Event.image_load_real_failed, "ChatWindowActivity", true));
            UICallbackExecutor.executeDelayed(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.a(r111, r100, r101), 1500);
        L6:
            v r112 = this.f412200f;
            if (r112 == null) goto L10;
            r112.onFinish();
            return;
        }

        @Override // com.ss.android.lark.image.entity.ListenerParams.b
        public final void b(Object r100, Object r101, DataSource r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r102, "dataSource");
            Log.i("ImageCellLoader", "image load success, messageId=" + this.f412198d + ", imageKey=" + this.f412199e);
            ThreadUtils.runOnUIThread(new com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image.b(r100, this));
            ChatImageErrDetector r104 = (ChatImageErrDetector) this.f412201g.getValue();
            String r105 = this.f412198d;
            String r106 = this.f412199e;
            r104.getClass();
            Intrinsics.checkNotNullParameter(r105, RemoteMessageConst.MSGID);
            if (r106 == null) goto L9;
            ConcurrentHashMap r107 = (ConcurrentHashMap) ChatImageErrDetector.f413592a;
            if (r107.containsKey(new ChatImageErrDetector.b(r105, r106)) == false) goto L9;
            r107.put(new ChatImageErrDetector.b(r105, r106), Boolean.TRUE);
        L9:
            v r108 = this.f412200f;
            if (r108 == null) goto L13;
            r108.onFinish();
            return;
        }

        public b(m2b.a r100, ImageContentBlock.b r101, com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image.a r102, String r103, String r104, m r105) {
            Intrinsics.checkNotNullParameter(r100, "chatContext");
            Intrinsics.checkNotNullParameter(r101, "holder");
            Intrinsics.checkNotNullParameter(r102, "imageInfo");
            Intrinsics.checkNotNullParameter(r103, "messageId");
            this.f412195a = r100;
            this.f412196b = r101;
            this.f412197c = r102;
            this.f412198d = r103;
            this.f412199e = r104;
            this.f412200f = r105;
            this.f412201g = LazyKt.lazy(ImageCellLoader$GifRequestListener$chatImageErrDetector$2.INSTANCE);
        }
    }

    public interface c {
        MarkView a();
    }

    static {
    }

    public ImageCellLoader(m2b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "chatContext");
        this.f412191a = r100;
        this.f412193c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new ImageCellLoader$holderCal$2(this));
        this.f412194d = LazyKt.lazy(ImageCellLoader$chatImageErrDetector$2.INSTANCE);
    }

    public final int a(y6b.a<ImageContentVO> r100, v4b.d r101) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        lya.a r102 = this.f412191a.l();
        y6b.c r103 = null;
        if (r102 == null) goto L5;
        Integer r104 = r102.a();
    L6:
        int r105 = UIHelper.dp2px(680.0f);
        boolean r106 = false;
        int r107 = 0;
        if (r101 == null) goto L9;
        int r108 = r101.f553210d;
    L10:
        if (r108 <= 0) goto L14;
        if (r101 == null) goto L47;
        r107 = r101.f553210d;
    L47:
        return RangesKt.coerceAtMost(r105, r107);
    L14:
        if (this.f412191a.q() == false) goto L22;
        if ((r100 instanceof y6b.c) == true) goto L18;
    L20:
        r107 = j.l(this.f412191a.getContext(), f3b.b.a(this.f412191a));
        goto L47
    L18:
        if (((y6b.c) r100).W2 != (-1)) goto L20;
        r107 = j.k(this.f412191a.getContext(), f3b.b.a(this.f412191a));
        goto L47
    L22:
        if (this.f412191a.r() == false) goto L25;
        r107 = j.b(this.f412191a.getContext(), f3b.b.a(this.f412191a));
        goto L47
    L25:
        if (this.f412191a.m() == false) goto L37;
        FragmentActivity r109 = this.f412191a.getContext();
        Integer r110 = f3b.b.a(this.f412191a);
        boolean r111 = r100 instanceof y6b.c;
        if (r111 == false) goto L29;
        y6b.c r112 = (y6b.c) r100;
    L30:
        boolean r113 = q7b.c.a(r112, this.f412191a);
        if (r111 == false) goto L33;
        r103 = (y6b.c) r100;
    L33:
        if (r103 == null) goto L35;
        r106 = r103.V1;
    L35:
        r107 = j.e(r109, r110, r113, r106);
        goto L47
    L29:
        r112 = null;
        goto L30
    L37:
        if (this.f412191a.Y() == true) goto L39;
        r107 = j.d(this.f412191a.getContext(), r104);
        goto L47
    L39:
        if ((r100 instanceof y6b.c) == false) goto L44;
        y6b.c r114 = (y6b.c) r100;
        if (r114.Y() == false) goto L43;
        r107 = j.i(this.f412191a.getContext(), r114.V1, f3b.b.a(this.f412191a), q7b.c.a(r114, this.f412191a));
        goto L47
    L43:
        r107 = j.j(this.f412191a.getContext(), r114.V1, f3b.b.a(this.f412191a), q7b.c.a(r114, this.f412191a));
        goto L47
    L44:
        r107 = j.d(this.f412191a.getContext(), r104);
        goto L47
    L9:
        r108 = 0;
        goto L10
    L5:
        r104 = null;
        goto L6
    }
}
