package com.bytedance.ee.lark.infra.file;

import android.util.SparseArray;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import fs5.c;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes19.dex */
public abstract class AbsFileManager implements c {

    /* JADX INFO: renamed from: com.bytedance.ee.lark.infra.file.AbsFileManager$1, reason: invalid class name */
    public class AnonymousClass1 extends ConcurrentHashMap<String, Boolean> {
        final /* synthetic */ AbsFileManager this$0;

        public AnonymousClass1(AbsFileManager r100) {
            this.this$0 = r100;
            Boolean r101 = Boolean.FALSE;
            put("temp", r101);
            put("private_tmp", r101);
        }
    }

    public class a extends SparseArray<String> {
        public a() {
            put(49152, "socket");
            put(UnixStat.LINK_FLAG, "symbolic_link");
            put(32768, "regular_file");
            put(24576, "block_device");
            put(16384, "directory");
            put(8192, "character_device");
            put(4096, "FIFO_pipe");
        }
    }

    public abstract String a();

    public abstract String b();

    static {
        new a();
    }
}
