package ng4;

import com.bytedance.component.lyric_v2.util.LyricType;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<pg4.d> f519069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LyricType f519070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<pg4.d> f519071c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f519072d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Float> f519073e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f519074f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f519075g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f519076h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final pg4.c f519077i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f519078j;

    public final String toString() {
        return "LyricRequest(url='" + this.f519074f + "', savePath='" + this.f519075g + "', fileName='" + this.f519076h + "', config=" + this.f519077i + ", lineInfos=" + this.f519069a + ", lyricType=" + this.f519070b + ", drawLyricLines=" + this.f519071c + ", drawNode=" + this.f519072d + ", textMeasuredLengthMap=" + this.f519073e + ')';
    }

    public l(String r100, String r101, String r102, pg4.c r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, DBDefinition.SAVE_PATH);
        Intrinsics.checkNotNullParameter(r102, "fileName");
        Intrinsics.checkNotNullParameter(r103, "config");
        Intrinsics.checkNotNullParameter(r104, "localPath");
        this.f519074f = r100;
        this.f519075g = r101;
        this.f519076h = r102;
        this.f519077i = r103;
        this.f519078j = r104;
        this.f519070b = LyricType.KRC;
        this.f519071c = new ArrayList();
        this.f519073e = new LinkedHashMap();
    }
}
