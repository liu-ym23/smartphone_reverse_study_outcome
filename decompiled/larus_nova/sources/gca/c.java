package gca;

import com.larus.im.bean.message.block.BlockType;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f480885a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f480886b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<Integer> f480887c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<Integer> f480888d = null;

    static {
        f480885a = LazyKt.lazy(new a());
        f480886b = LazyKt.lazy(new b());
        f480887c = SetsKt.setOf(new Integer[]{Integer.valueOf(BlockType.BLOCK_TYPE_O_COMPLEX_CALL_FOR_ME.getValue()), Integer.valueOf(BlockType.BLOCK_TYPE_O_SEARCH_QUERY_RESULT.getValue())});
        f480888d = SetsKt.setOf(new Integer[]{Integer.valueOf(BlockType.BLOCK_TYPE_O_REFERENCE_MSG.getValue()), Integer.valueOf(BlockType.BLOCK_TYPE_O_NORMAL_CLICK_INTENT.getValue())});
    }
}
