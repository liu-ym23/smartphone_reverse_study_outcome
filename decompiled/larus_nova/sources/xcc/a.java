package xcc;

import com.larksuite.component.universe_design.dialog.UDDialog;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.widget.photo.preview.video.online.r;
import com.ss.android.lark.widget.photo.preview.video.speed.PlaySpeedLevel;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final List<PlaySpeedLevel> f563253e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f563254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MessageIdentity f563255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public UDDialog f563256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PlaySpeedLevel f563257d;

    /* JADX INFO: renamed from: xcc.a$a, reason: collision with other inner class name */
    public static final class C8215a {
    }

    public interface b {
    }

    static {
        f563253e = CollectionsKt.listOf(new PlaySpeedLevel[]{PlaySpeedLevel.LEVEL_SLOW, PlaySpeedLevel.LEVEL_NORMAL, PlaySpeedLevel.LEVEL_VERY_FAST, PlaySpeedLevel.LEVEL_2X, PlaySpeedLevel.LEVEL_3X});
    }

    public a(r r100, MessageIdentity r101) {
        Intrinsics.checkNotNullParameter(r100, "onSpeedChange");
        this.f563254a = r100;
        this.f563255b = r101;
        this.f563257d = PlaySpeedLevel.LEVEL_NORMAL;
    }
}
