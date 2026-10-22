package iv7;

import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes23.dex */
public final class i extends Inflater {
    @Override // java.util.zip.Inflater
    public final void end() {
    }

    public final void a() {
        super.end();
    }

    @Override // java.util.zip.Inflater
    public final void finalize() {
        super.end();
    }

    public i(boolean r100) {
        super(r100);
    }
}
