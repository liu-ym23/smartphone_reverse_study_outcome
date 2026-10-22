package com.larus.bmhome.common_ui.image;

import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.bigimg.n1;
import com.larus.common_ui.photoviewer.PhotoViewerDialog;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import l19.f;
import org.json.JSONObject;
import uo8.k;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 $2\u00020\u0001:\u0001$B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bB'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bB7\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000eB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0007\u0010\u0011J\u000f\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0002\u0010!J\u0010\u0010\u0015\u001a\u00020\"2\u0006\u0010#\u001a\u00020 H\u0004R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006%"}, d2 = {"Lcom/larus/bmhome/common_ui/image/CustomPhotoViewerDialog;", "Lcom/larus/common_ui/photoviewer/PhotoViewerDialog;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "imageUrls", "", "Lcom/larus/bmhome/bigimg/ImagePreviewDownloadUrl;", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "eventParams", "Lcom/larus/bmhome/common_ui/image/PhotoViewerReportParams;", "(Landroid/content/Context;Ljava/util/List;Lcom/larus/bmhome/common_ui/image/PhotoViewerReportParams;)V", "imageThumbUrls", "", "(Landroid/content/Context;Ljava/util/List;Ljava/util/List;Lcom/larus/bmhome/common_ui/image/PhotoViewerReportParams;)V", "customTransitionAdapter", "Lcom/larus/bmhome/common_ui/image/CustomPhotoTransitionPagerAdapter;", "(Landroid/content/Context;Lcom/larus/bmhome/common_ui/image/CustomPhotoTransitionPagerAdapter;)V", "getCustomTransitionAdapter", "()Lcom/larus/bmhome/common_ui/image/CustomPhotoTransitionPagerAdapter;", "reportParams", "getReportParams", "()Lcom/larus/bmhome/common_ui/image/PhotoViewerReportParams;", "setReportParams", "(Lcom/larus/bmhome/common_ui/image/PhotoViewerReportParams;)V", "extraView", "Landroid/view/View;", "getExtraView", "()Landroid/view/View;", "setExtraView", "(Landroid/view/View;)V", "getExtraViewLayout", "", "()Ljava/lang/Integer;", "Lorg/json/JSONObject;", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "Companion", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CustomPhotoViewerDialog extends PhotoViewerDialog {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final CustomPhotoTransitionPagerAdapter f310674n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final k f310675o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final View f310676p;

    public static final class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomPhotoViewerDialog f310677a;

        @Override // l19.f
        public final void onTransitionChanged(int r100, float r101) {
        }

        public a(CustomPhotoViewerDialog r100) {
            this.f310677a = r100;
        }

        @Override // l19.f
        public final void onTransitionBegin(int r100) {
            View r101 = this.f310677a.f310676p;
            if (r101 == null) goto L6;
            r101.setVisibility(8);
            return;
        }

        @Override // l19.f
        public final void onTransitionEnd(int r100) {
            View r101 = this.f310677a.f310676p;
            if (r101 == null) goto L6;
            r101.setVisibility(0);
            return;
        }
    }

    public static final class b {
    }

    static {
    }

    public Integer g() {
        return null;
    }

    public final JSONObject h(int r100) {
        JSONObject r101 = new JSONObject();
        k r102 = this.f310675o;
        if (r102 == null) goto L19;
        Map<String, Object> r103 = r102.f550934a;
        if (r103 == null) goto L10;
        Iterator<Map.Entry<String, Object>> r104 = r103.entrySet().iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        Map.Entry<String, Object> r105 = r104.next();
        r101.put(r105.getKey(), r105.getValue());
    L10:
        List<Map<String, Object>> r106 = r102.f550935b;
        if (r106 == null) goto L19;
        if (r100 < 0) goto L19;
        if (r100 >= r106.size()) goto L19;
        Iterator r107 = ((Map) ListProtector.get(r106, r100)).entrySet().iterator();
    L17:
        if (r107.hasNext() == false) goto L19;
        Map.Entry r108 = (Map.Entry) r107.next();
        r101.put((String) r108.getKey(), r108.getValue());
    L19:
        return r101;
    }

    public CustomPhotoViewerDialog(Context r100, CustomPhotoTransitionPagerAdapter r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "customTransitionAdapter");
        super(r100, r101);
        this.f310674n = r101;
        Window r102 = getWindow();
        if (r102 == null) goto L5;
        r102.setExitTransition(null);
    L5:
        Window r103 = getWindow();
        if (r103 == null) goto L8;
        r103.setReturnTransition(null);
    L8:
        Integer r104 = g();
        if (r104 == null) goto L11;
        View r105 = getLayoutInflater().inflate(r104.intValue(), this.f327628c, false);
        this.f310676p = r105;
        this.f327628c.addView(r105, new FrameLayout.LayoutParams(-1, -1));
    L11:
        r101.f310666p = new a(this);
    }

    public CustomPhotoViewerDialog(Context r100, List<n1> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "imageUrls");
        CustomPhotoTransitionPagerAdapter r102 = new CustomPhotoTransitionPagerAdapter();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r102.f310661k = r101;
        Unit r103 = Unit.INSTANCE;
        this(r100, r102);
    }

    public CustomPhotoViewerDialog(Context r100, List<n1> r101, List<String> r102, k r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "imageUrls");
        Intrinsics.checkNotNullParameter(r103, "eventParams");
        CustomPhotoTransitionPagerAdapter r104 = new CustomPhotoTransitionPagerAdapter();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r104.f310661k = r101;
        r104.f310662l = r102;
        Unit r105 = Unit.INSTANCE;
        this(r100, r104);
        this.f310675o = r103;
    }
}
