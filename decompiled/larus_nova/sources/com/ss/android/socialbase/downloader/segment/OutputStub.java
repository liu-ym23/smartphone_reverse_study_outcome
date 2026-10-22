package com.ss.android.socialbase.downloader.segment;

import java.io.IOException;

/* JADX INFO: loaded from: classes38.dex */
class OutputStub implements IOutput {
    private final IOutput output;
    private final IOutput target;

    @Override // com.ss.android.socialbase.downloader.segment.IOutput
    public void write(Buffer r100) throws IOException {
        r100.output = this.target;
        this.output.write(r100);
    }

    public OutputStub(IOutput r100, IOutput r101) {
        this.output = r100;
        this.target = r101;
    }
}
