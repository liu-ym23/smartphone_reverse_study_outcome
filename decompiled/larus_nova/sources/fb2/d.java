package fb2;

import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes9.dex */
public final class d<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkedHashMap f476255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HashMap f476256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f476257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ db2.b f476258d;

    public d(LinkedHashMap r100, HashMap r101, long r102, db2.b r103) {
        this.f476255a = r100;
        this.f476256b = r101;
        this.f476257c = r102;
        this.f476258d = r103;
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r110) {
        BaseEmoji r101 = (BaseEmoji) r100;
        BaseEmoji r111 = (BaseEmoji) r110;
        com.bytedance.android.livesdk.interactivity.service.emoji.recent.b r102 = (com.bytedance.android.livesdk.interactivity.service.emoji.recent.b) this.f476255a.get(r101.getDescription());
        if (r102 != null) goto L5;
        r102 = new com.bytedance.android.livesdk.interactivity.service.emoji.recent.b(r101.getDescription(), 0, new ArrayList());
    L5:
        b r103 = (b) this.f476256b.get(r101.getDescription());
        int r104 = 1;
        if (r103 == null) goto L8;
        int r105 = r103.f476252b;
    L9:
        float r106 = r102.a(this.f476257c, r105, this.f476258d);
        com.bytedance.android.livesdk.interactivity.service.emoji.recent.b r107 = (com.bytedance.android.livesdk.interactivity.service.emoji.recent.b) this.f476255a.get(r111.getDescription());
        if (r107 != null) goto L12;
        r107 = new com.bytedance.android.livesdk.interactivity.service.emoji.recent.b(r111.getDescription(), 0, new ArrayList());
    L12:
        b r108 = (b) this.f476256b.get(r111.getDescription());
        if (r108 == null) goto L15;
        r104 = r108.f476252b;
    L15:
        float r109 = r107.a(this.f476257c, r104, this.f476258d);
        r101.recommendScore = r106;
        r111.recommendScore = r109;
        return -Float.compare(r106, r109);
    L8:
        r105 = 1;
        goto L9
    }
}
