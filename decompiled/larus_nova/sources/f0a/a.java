package f0a;

import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.platform.api.Image;
import com.larus.platform.api.creation.AudioResource;
import com.larus.platform.api.creation.VideoResource;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ResourceType f475010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Image f475011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final VideoResource f475012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AudioResource f475013d;

    public a(ResourceType r100, Image r101, VideoResource r102, AudioResource r103, int r104) {
        if ((r104 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = null;
    L8:
        this.f475010a = r100;
        this.f475011b = r101;
        this.f475012c = r102;
        this.f475013d = r103;
    }
}
