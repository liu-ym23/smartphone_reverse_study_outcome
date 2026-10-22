package mjc;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f514266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Object> f514267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<b> f514268c;

    public a() {
        this(1.0f, null);
    }

    public final Object clone() throws CloneNotSupportedException {
        return new a(this.f514266a, this.f514268c);
    }

    public final String toString() {
        return "IESVideoClipAudioConfiguration{volume=" + this.f514266a + ", startVolumeEdge=null, endVolumeEdge=null, nodes=" + this.f514268c + '}';
    }

    public a(float r100, List r101) {
        this.f514266a = r100;
        ArrayList r102 = new ArrayList();
        this.f514268c = r102;
        if (r101 == null) goto L5;
        r102.addAll(r101);
    L5:
        this.f514267b = new ArrayList();
    }
}
