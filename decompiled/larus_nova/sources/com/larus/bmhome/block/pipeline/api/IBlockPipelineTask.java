package com.larus.bmhome.block.pipeline.api;

import com.larus.im.bean.message.block.Block;
import java.util.List;
import kc8.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\b\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b2\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000bH\u0016J,\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000bH\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0014"}, d2 = {"Lcom/larus/bmhome/block/pipeline/api/IBlockPipelineTask;", "Lcom/bytedance/kmp/spi/IKmpService;", "priority", "", "getPriority", "()I", "supports", "", "blockPipelineConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockPipelineConfig;", "processBlocks", "", "Lcom/larus/im/bean/message/block/Block;", "blockList", "processBizModels", "Lcom/larus/bmhome/chat/block/base/BaseBlockBizModel;", "bizModelList", "onPipelineCompleted", "", "sourceBlockList", "block-kit-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IBlockPipelineTask extends pd6.a {

    /* JADX INFO: loaded from: classes25.dex */
    public static final class a {
        public static void a(f r100, List r101, List r102) {
            Intrinsics.checkNotNullParameter(r100, "blockPipelineConfig");
            Intrinsics.checkNotNullParameter(r101, "sourceBlockList");
            Intrinsics.checkNotNullParameter(r102, "bizModelList");
        }

        public static void b(f r100, List r101) {
            Intrinsics.checkNotNullParameter(r100, "blockPipelineConfig");
            Intrinsics.checkNotNullParameter(r101, "bizModelList");
        }

        public static void c(f r100, List r101) {
            Intrinsics.checkNotNullParameter(r100, "blockPipelineConfig");
            Intrinsics.checkNotNullParameter(r101, "blockList");
        }
    }

    List<Block> d3(f r100, List<Block> r101);

    int getPriority();

    List<jc8.a> k2(f r100, List<? extends jc8.a> r101);

    void m2(f r100, List<Block> r101, List<? extends jc8.a> r102);

    boolean n1(f r100);
}
