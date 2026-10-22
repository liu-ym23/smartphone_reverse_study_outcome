package o79;

import com.larus.drive.biz.api.model.DriveFileType;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f522280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<DriveFileType> f522281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<DriveFileType> f522282c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f522283d;

    public c() {
        this.f522280a = LazyKt.lazy(new a());
        DriveFileType r100 = DriveFileType.AI_SLIDES;
        DriveFileType r101 = DriveFileType.AI_DOC;
        DriveFileType r102 = DriveFileType.AI_SHEET;
        this.f522281b = SetsKt.setOf(new DriveFileType[]{r100, r101, r102});
        this.f522282c = SetsKt.setOf(new DriveFileType[]{r100, r101, r102});
        this.f522283d = LazyKt.lazy(new b(this));
    }
}
