package com.ss.android.socialbase.appdownloader.util.parser.manifest;

import java.io.IOException;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes38.dex */
public class ExtCountingDataInput extends ExtDataInput {
    private static final Logger LOGGER = null;
    private final CountingInputStream mCountIn;

    static {
        LOGGER = Logger.getLogger(ExtCountingDataInput.class.getName());
    }

    public int position() {
        return this.mCountIn.getCount();
    }

    public int remaining() throws IOException {
        return this.mCountIn.available();
    }

    public ExtCountingDataInput(CountingInputStream r100) {
        super(new LittleEndianDataInputStream(r100));
        this.mCountIn = r100;
    }

    public long skip(int r100) throws IOException {
        return this.mCountIn.skip(r100);
    }

    public ExtCountingDataInput(LittleEndianDataInputStream r100) {
        this(new CountingInputStream(r100));
    }

    public int[] readSafeIntArray(int r100, long r101) throws IOException {
        int[] r102 = new int[r100];
        int r103 = 0;
    L3:
        if (r103 >= r100) goto L9;
        if (position() >= r101) goto L6;
        r102[r103] = readInt();
        r103 = r103 + 1;
        goto L3
    L6:
        LOGGER.warning(String.format("Bad string block: string entry is at %d, past end at %d", new Object[]{Integer.valueOf(position()), Long.valueOf(r101)}));
        return r102;
    L9:
        return r102;
    }
}
