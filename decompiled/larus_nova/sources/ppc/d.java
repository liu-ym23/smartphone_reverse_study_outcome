package ppc;

import android.graphics.BitmapFactory;
import android.util.Size;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.ImageContent;
import com.ss.android.lark.forwardv3.configuration.IForwardContent;
import com.ss.android.lark.forwardv3.forward.imageforward.ImageForwardContent;
import com.ss.android.lark.forwardv3.messageforward.SingleMessageForwardContent;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f530248a = null;

    static {
        f530248a = new d();
    }

    public d() {
    }

    @Override // ppc.e
    public final boolean a(g r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        IForwardContent r101 = r100.f530254d.getForwardContent();
        if ((r101 instanceof ImageForwardContent) == false) goto L5;
    L14:
        return true;
    L5:
        if ((r101 instanceof SingleMessageForwardContent) == false) goto L13;
        Message r102 = r100.f530254d.getSourceMessage();
        if (r102 == null) goto L9;
        Message.Type r103 = r102.getType();
    L11:
        if (r103 != Message.Type.IMAGE) goto L13;
    L9:
        r103 = null;
    L13:
        return false;
    }

    @Override // ppc.e
    public final boolean b(g r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        IForwardContent r100 = r110.f530254d.getForwardContent();
        if ((r100 instanceof ImageForwardContent) == false) goto L12;
        String r101 = (String) CollectionsKt.firstOrNull(((ImageForwardContent) r100).f425358b);
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r101, "path");
        if (StringsKt.isBlank(r101) == false) goto L10;
        return false;
    L10:
        BitmapFactory.Options r102 = new BitmapFactory.Options();
        r102.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r101, r102);
        Size r103 = h.b(r102.outWidth, r102.outHeight);
        ImageView r104 = h.c(r110);
        r110.f530253c.setBackground(null);
        r110.f530253c.addView(r104, new FrameLayout.LayoutParams(r103.getWidth(), r103.getHeight(), 17));
        ImageLoader.with(r110.getActivity()).load(r101).centerCrop().override(r103.getWidth(), r103.getHeight()).into(r104);
        r110.f530253c.setVisibility(0);
        return true;
    L12:
        Message r105 = r110.f530254d.getSourceMessage();
        if (r105 == null) goto L15;
        ImageContent r106 = (ImageContent) r105.getContent();
    L17:
        if ((r106 instanceof ImageContent) == true) goto L20;
        r106 = null;
    L20:
        if (r106 == null) goto L47;
        ImageSet r107 = r106.getImageSet();
        if (r107 == null) goto L47;
        Image r108 = r107.getOrigin();
        if (r108 == null) goto L29;
        List<String> r109 = r108.getUrls();
        if (r109 == null) goto L29;
        String r111 = (String) CollectionsKt.firstOrNull(r109);
    L30:
        if (r111 != null) goto L32;
    L35:
        boolean r112 = true;
    L36:
        if (r112 == false) goto L38;
    L40:
        Image r113 = r107.getThumbnail();
        if (r113 != null) goto L46;
        Image r114 = r107.getMiddle();
        if (r114 == null) goto L48;
        r108 = r114;
    L48:
        if (r108 != null) goto L50;
        r108 = r110.f530254d.getDialogContent().f425134g;
    L50:
        Image r115 = r108;
        if (r115 == null) goto L53;
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r115, "image");
        Size r116 = h.b(r115.getWidth(), r115.getHeight());
        ImageView r117 = h.c(r110);
        r110.f530253c.setBackground(null);
        r110.f530253c.addView(r117, new FrameLayout.LayoutParams(r116.getWidth(), r116.getHeight(), 17));
        com.ss.android.lark.forwardv3.utils.a.a(r110.getActivity(), r117, false, r115, true, false, r116.getWidth(), r116.getHeight());
        r110.f530253c.setVisibility(0);
        return true;
    L53:
        return false;
    L46:
        r108 = r113;
        goto L48
    L38:
        if (URLUtil.isNetworkUrl(r111) == true) goto L40;
    L32:
        if (StringsKt.isBlank(r111) == true) goto L35;
        r112 = false;
    L29:
        r111 = null;
    L47:
        r108 = null;
        goto L48
    L15:
        r106 = null;
        goto L17
    }
}
