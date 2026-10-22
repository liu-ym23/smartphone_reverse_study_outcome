package rob;

import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter.ItemType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f538804c;

    @Override // rob.g
    public final Object a() {
        return this.f538804c;
    }

    public a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        super(ItemType.AsrLanguage, r100);
        this.f538804c = r100;
    }
}
