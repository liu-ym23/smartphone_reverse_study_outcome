package org.apache.commons.compress.archivers.zip;

import java.util.zip.ZipEntry;
import org.apache.commons.compress.archivers.ArchiveEntry;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public class ZipArchiveEntry extends ZipEntry implements ArchiveEntry {

    public static final enum CommentSource extends Enum<CommentSource> {
        private static final /* synthetic */ CommentSource[] $VALUES = null;
        public static final CommentSource COMMENT = null;
        public static final CommentSource UNICODE_EXTRA_FIELD = null;

        static {
            CommentSource r100 = new CommentSource("COMMENT", 0);
            COMMENT = r100;
            CommentSource r101 = new CommentSource("UNICODE_EXTRA_FIELD", 1);
            UNICODE_EXTRA_FIELD = r101;
            $VALUES = new CommentSource[]{r100, r101};
        }

        public static CommentSource[] values() {
            return (CommentSource[]) $VALUES.clone();
        }

        public static CommentSource valueOf(String r100) {
            return (CommentSource) a.a(CommentSource.class, r100);
        }

        private CommentSource(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum NameSource extends Enum<NameSource> {
        private static final /* synthetic */ NameSource[] $VALUES = null;
        public static final NameSource NAME = null;
        public static final NameSource NAME_WITH_EFS_FLAG = null;
        public static final NameSource UNICODE_EXTRA_FIELD = null;

        static {
            NameSource r100 = new NameSource("NAME", 0);
            NAME = r100;
            NameSource r101 = new NameSource("NAME_WITH_EFS_FLAG", 1);
            NAME_WITH_EFS_FLAG = r101;
            NameSource r102 = new NameSource("UNICODE_EXTRA_FIELD", 2);
            UNICODE_EXTRA_FIELD = r102;
            $VALUES = new NameSource[]{r100, r101, r102};
        }

        public static NameSource[] values() {
            return (NameSource[]) $VALUES.clone();
        }

        public static NameSource valueOf(String r100) {
            return (NameSource) a.a(NameSource.class, r100);
        }

        private NameSource(String r100, int r101) {
            super(r100, r101);
        }
    }
}
