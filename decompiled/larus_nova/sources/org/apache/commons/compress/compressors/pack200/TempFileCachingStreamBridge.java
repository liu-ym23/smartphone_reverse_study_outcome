package org.apache.commons.compress.compressors.pack200;

import java.io.File;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;

/* JADX INFO: loaded from: classes42.dex */
class TempFileCachingStreamBridge extends StreamBridge {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final File f525011f;

    public TempFileCachingStreamBridge() throws IOException {
        File r100 = File.createTempFile("commons-compress", "packtemp");
        this.f525011f = r100;
        r100.deleteOnExit();
        ((FilterOutputStream) this).out = Files.newOutputStream(r100.toPath(), new OpenOption[0]);
    }
}
