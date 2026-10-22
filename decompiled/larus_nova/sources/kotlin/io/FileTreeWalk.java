package kotlin.io;

import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.dtf.toyger.base.face.ToygerFaceAlgorithmConfig;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.AbstractIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001a\u001b\u001cB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0089\u0001\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b\u00128\u0010\f\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0096\u0002J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0014J\u001a\u0010\u0007\u001a\u00020\u00002\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\bJ \u0010\f\u001a\u00020\u00002\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b0\rJ\u001a\u0010\n\u001a\u00020\u00002\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\f\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lkotlin/io/FileTreeWalk;", "Lkotlin/sequences/Sequence;", "Ljava/io/File;", "start", "direction", "Lkotlin/io/FileWalkDirection;", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;)V", "onEnter", "Lkotlin/Function1;", "", "onLeave", "", "onFail", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "f", "Ljava/io/IOException;", "e", "maxDepth", "", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;I)V", "iterator", "", ToygerFaceAlgorithmConfig.DEPTH, "function", "DirectoryState", "FileTreeWalkIterator", "WalkState", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FileTreeWalk implements Sequence<File> {
    private final FileWalkDirection direction;
    private final int maxDepth;
    private final Function1<File, Boolean> onEnter;
    private final Function2<File, IOException, Unit> onFail;
    private final Function1<File, Unit> onLeave;
    private final File start;

    /* JADX INFO: loaded from: classes6.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\"\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/io/FileTreeWalk$DirectoryState;", "Lkotlin/io/FileTreeWalk$WalkState;", "rootDir", "Ljava/io/File;", "(Ljava/io/File;)V", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class DirectoryState extends WalkState {
        public DirectoryState(File r100) {
            Intrinsics.checkNotNullParameter(r100, "rootDir");
            super(r100);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\r\u000e\u000fB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0014J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0082\u0010R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;", "Lkotlin/collections/AbstractIterator;", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk;)V", "state", "Ljava/util/ArrayDeque;", "Lkotlin/io/FileTreeWalk$WalkState;", "computeNext", "", "directoryState", "Lkotlin/io/FileTreeWalk$DirectoryState;", RootDescription.ROOT_ELEMENT, "gotoNext", "BottomUpDirectoryState", "SingleFileState", "TopDownDirectoryState", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class FileTreeWalkIterator extends AbstractIterator<File> {
        private final ArrayDeque<WalkState> state;
        final /* synthetic */ FileTreeWalk this$0;

        /* JADX INFO: loaded from: classes6.dex */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$BottomUpDirectoryState;", "Lkotlin/io/FileTreeWalk$DirectoryState;", "rootDir", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "failed", "", "fileIndex", "", "fileList", "", "[Ljava/io/File;", "rootVisited", "step", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public final class BottomUpDirectoryState extends DirectoryState {
            private boolean failed;
            private int fileIndex;
            private File[] fileList;
            private boolean rootVisited;
            final /* synthetic */ FileTreeWalkIterator this$0;

            @Override // kotlin.io.FileTreeWalk.WalkState
            public File step() {
                if (this.failed == false) goto L5;
            L19:
                File[] r100 = this.fileList;
                if (r100 == null) goto L26;
                int r101 = this.fileIndex;
                Intrinsics.checkNotNull(r100);
                if (r101 >= r100.length) goto L26;
                File[] r102 = this.fileList;
                Intrinsics.checkNotNull(r102);
                int r103 = this.fileIndex;
                this.fileIndex = r103 + 1;
                return r102[r103];
            L26:
                if (this.rootVisited == true) goto L29;
                this.rootVisited = true;
                return getRoot();
            L29:
                Function1 r104 = FileTreeWalk.access$getOnLeave$p(this.this$0.this$0);
                if (r104 == null) goto L32;
                r104.invoke(getRoot());
            L32:
                return null;
            L5:
                if (this.fileList != null) goto L19;
                Function1 r105 = FileTreeWalk.access$getOnEnter$p(this.this$0.this$0);
                boolean r106 = false;
                if (r105 != null) goto L9;
            L11:
                if (r106 == false) goto L13;
                return null;
            L13:
                File[] r107 = getRoot().listFiles();
                this.fileList = r107;
                if (r107 != null) goto L19;
                Function2 r108 = FileTreeWalk.access$getOnFail$p(this.this$0.this$0);
                if (r108 == null) goto L18;
                r108.invoke(getRoot(), new AccessDeniedException(getRoot(), null, "Cannot list files in a directory", 2, null));
            L18:
                this.failed = true;
                goto L19
            L9:
                if (((Boolean) r105.invoke(getRoot())).booleanValue() == true) goto L11;
                r106 = true;
                goto L11
            }

            public BottomUpDirectoryState(FileTreeWalkIterator r100, File r101) {
                Intrinsics.checkNotNullParameter(r101, "rootDir");
                this.this$0 = r100;
                super(r101);
            }
        }

        /* JADX INFO: loaded from: classes6.dex */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$SingleFileState;", "Lkotlin/io/FileTreeWalk$WalkState;", "rootFile", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "visited", "", "step", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public final class SingleFileState extends WalkState {
            final /* synthetic */ FileTreeWalkIterator this$0;
            private boolean visited;

            @Override // kotlin.io.FileTreeWalk.WalkState
            public File step() {
                if (this.visited == false) goto L6;
                return null;
            L6:
                this.visited = true;
                return getRoot();
            }

            public SingleFileState(FileTreeWalkIterator r100, File r101) {
                Intrinsics.checkNotNullParameter(r101, "rootFile");
                this.this$0 = r100;
                super(r101);
            }
        }

        /* JADX INFO: loaded from: classes6.dex */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$TopDownDirectoryState;", "Lkotlin/io/FileTreeWalk$DirectoryState;", "rootDir", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "fileIndex", "", "fileList", "", "[Ljava/io/File;", "rootVisited", "", "step", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public final class TopDownDirectoryState extends DirectoryState {
            private int fileIndex;
            private File[] fileList;
            private boolean rootVisited;
            final /* synthetic */ FileTreeWalkIterator this$0;

            @Override // kotlin.io.FileTreeWalk.WalkState
            public File step() {
                if (this.rootVisited == true) goto L13;
                Function1 r100 = FileTreeWalk.access$getOnEnter$p(this.this$0.this$0);
                boolean r101 = false;
                if (r100 != null) goto L7;
            L9:
                if (r101 == false) goto L11;
                return null;
            L11:
                this.rootVisited = true;
                return getRoot();
            L7:
                if (((Boolean) r100.invoke(getRoot())).booleanValue() == true) goto L9;
                r101 = true;
                goto L9
            L13:
                File[] r102 = this.fileList;
                if (r102 == null) goto L23;
                int r103 = this.fileIndex;
                Intrinsics.checkNotNull(r102);
                if (r103 < r102.length) goto L23;
                Function1 r104 = FileTreeWalk.access$getOnLeave$p(this.this$0.this$0);
                if (r104 == null) goto L21;
                r104.invoke(getRoot());
            L21:
                return null;
            L23:
                if (this.fileList != null) goto L37;
                File[] r105 = getRoot().listFiles();
                this.fileList = r105;
                if (r105 != null) goto L29;
                Function2 r106 = FileTreeWalk.access$getOnFail$p(this.this$0.this$0);
                if (r106 == null) goto L29;
                r106.invoke(getRoot(), new AccessDeniedException(getRoot(), null, "Cannot list files in a directory", 2, null));
            L29:
                File[] r107 = this.fileList;
                if (r107 == null) goto L33;
                Intrinsics.checkNotNull(r107);
                if (r107.length != 0) goto L37;
            L33:
                Function1 r108 = FileTreeWalk.access$getOnLeave$p(this.this$0.this$0);
                if (r108 == null) goto L36;
                r108.invoke(getRoot());
            L36:
                return null;
            L37:
                File[] r109 = this.fileList;
                Intrinsics.checkNotNull(r109);
                int r110 = this.fileIndex;
                this.fileIndex = r110 + 1;
                return r109[r110];
            }

            public TopDownDirectoryState(FileTreeWalkIterator r100, File r101) {
                Intrinsics.checkNotNullParameter(r101, "rootDir");
                this.this$0 = r100;
                super(r101);
            }
        }

        /* JADX INFO: loaded from: classes6.dex */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r100 = new int[FileWalkDirection.values().length];
                r100[FileWalkDirection.TOP_DOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[FileWalkDirection.BOTTOM_UP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                $EnumSwitchMapping$0 = r100;
            }
        }

        private final File gotoNext() {
        L2:
            WalkState r100 = this.state.peek();
            if (r100 == null) goto L4;
            File r101 = r100.step();
            if (r101 == null) goto L8;
            if (Intrinsics.areEqual(r101, r100.getRoot()) == true) goto L17;
            if (r101.isDirectory() == false) goto L17;
            if (this.state.size() >= FileTreeWalk.access$getMaxDepth$p(this.this$0)) goto L17;
            this.state.push(directoryState(r101));
        L17:
            return r101;
        L8:
            this.state.pop();
            goto L2
        L4:
            return null;
        }

        @Override // kotlin.collections.AbstractIterator
        public void computeNext() {
            File r100 = gotoNext();
            if (r100 == null) goto L5;
            setNext(r100);
            return;
        L5:
            done();
        }

        public FileTreeWalkIterator(FileTreeWalk r100) {
            this.this$0 = r100;
            ArrayDeque<WalkState> r101 = new ArrayDeque();
            this.state = r101;
            if (FileTreeWalk.access$getStart$p(r100).isDirectory() == false) goto L6;
            r101.push(directoryState(FileTreeWalk.access$getStart$p(r100)));
            return;
        L6:
            if (FileTreeWalk.access$getStart$p(r100).isFile() == false) goto L8;
            r101.push(new SingleFileState(this, FileTreeWalk.access$getStart$p(r100)));
            return;
        L8:
            done();
        }

        private final DirectoryState directoryState(File r100) {
            FileWalkDirection r101 = FileTreeWalk.access$getDirection$p(this.this$0);
            int r102 = WhenMappings.$EnumSwitchMapping$0[r101.ordinal()];
            if (r102 == 1) goto L10;
            if (r102 != 2) goto L8;
            return new BottomUpDirectoryState(this, r100);
        L8:
            throw new NoWhenBranchMatchedException();
        L10:
            return new TopDownDirectoryState(this, r100);
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\"\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lkotlin/io/FileTreeWalk$WalkState;", "", RootDescription.ROOT_ELEMENT, "Ljava/io/File;", "(Ljava/io/File;)V", "getRoot", "()Ljava/io/File;", "step", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class WalkState {
        private final File root;

        public abstract File step();

        public final File getRoot() {
            return this.root;
        }

        public WalkState(File r100) {
            Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
            this.root = r100;
        }
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<File> iterator() {
        return new FileTreeWalkIterator(this);
    }

    public static final /* synthetic */ FileWalkDirection access$getDirection$p(FileTreeWalk r100) {
        return r100.direction;
    }

    public static final /* synthetic */ int access$getMaxDepth$p(FileTreeWalk r100) {
        return r100.maxDepth;
    }

    public static final /* synthetic */ Function1 access$getOnEnter$p(FileTreeWalk r100) {
        return r100.onEnter;
    }

    public static final /* synthetic */ Function2 access$getOnFail$p(FileTreeWalk r100) {
        return r100.onFail;
    }

    public static final /* synthetic */ Function1 access$getOnLeave$p(FileTreeWalk r100) {
        return r100.onLeave;
    }

    public static final /* synthetic */ File access$getStart$p(FileTreeWalk r100) {
        return r100.start;
    }

    public final FileTreeWalk maxDepth(int r100) {
        if (r100 <= 0) goto L6;
        return new FileTreeWalk(this.start, this.direction, this.onEnter, this.onLeave, this.onFail, r100);
    L6:
        throw new IllegalArgumentException("depth must be positive, but was " + r100 + '.');
    }

    public final FileTreeWalk onEnter(Function1<? super File, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "function");
        return new FileTreeWalk(this.start, this.direction, r100, this.onLeave, this.onFail, this.maxDepth);
    }

    public final FileTreeWalk onFail(Function2<? super File, ? super IOException, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "function");
        return new FileTreeWalk(this.start, this.direction, this.onEnter, this.onLeave, r100, this.maxDepth);
    }

    public final FileTreeWalk onLeave(Function1<? super File, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "function");
        return new FileTreeWalk(this.start, this.direction, this.onEnter, r100, this.onFail, this.maxDepth);
    }

    public FileTreeWalk(File r110, FileWalkDirection r111) {
        Intrinsics.checkNotNullParameter(r110, "start");
        Intrinsics.checkNotNullParameter(r111, "direction");
        this(r110, r111, null, null, null, 0, 32, null);
    }

    public /* synthetic */ FileTreeWalk(File r100, FileWalkDirection r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = FileWalkDirection.TOP_DOWN;
    L5:
        this(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private FileTreeWalk(File r100, FileWalkDirection r101, Function1<? super File, Boolean> r102, Function1<? super File, Unit> r103, Function2<? super File, ? super IOException, Unit> r104, int r105) {
        this.start = r100;
        this.direction = r101;
        this.onEnter = r102;
        this.onLeave = r103;
        this.onFail = r104;
        this.maxDepth = r105;
    }

    public /* synthetic */ FileTreeWalk(File r100, FileWalkDirection r101, Function1 r110, Function1 r111, Function2 r112, int r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 2) == 0) goto L5;
        r101 = FileWalkDirection.TOP_DOWN;
    L5:
        FileWalkDirection r102 = r101;
        if ((r114 & 32) == 0) goto L8;
        int r103 = Integer.MAX_VALUE;
    L9:
        this(r100, r102, r110, r111, r112, r103);
        return;
    L8:
        r103 = r113;
        goto L9
    }
}
