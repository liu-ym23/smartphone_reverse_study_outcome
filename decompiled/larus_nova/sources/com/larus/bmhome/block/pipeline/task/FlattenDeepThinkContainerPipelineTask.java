package com.larus.bmhome.block.pipeline.task;

import com.larus.bmhome.block.pipeline.api.IBlockPipelineTask;
import com.larus.bmhome.chat.deepresearch.view.j;
import com.larus.im.bean.message.block.Block;
import java.util.Iterator;
import java.util.List;
import jc8.a;
import kc8.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/block/pipeline/task/FlattenDeepThinkContainerPipelineTask;", "Lcom/larus/bmhome/block/pipeline/api/IBlockPipelineTask;", "<init>", "()V", "priority", "", "getPriority", "()I", "supports", "", "blockPipelineConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockPipelineConfig;", "processBizModels", "", "Lcom/larus/bmhome/chat/block/base/BaseBlockBizModel;", "bizModelList", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlattenDeepThinkContainerPipelineTask implements IBlockPipelineTask {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f296393b;

    public FlattenDeepThinkContainerPipelineTask() {
        this.f296393b = 600;
    }

    @Override // com.larus.bmhome.block.pipeline.api.IBlockPipelineTask
    public final int getPriority() {
        return this.f296393b;
    }

    @Override // com.larus.bmhome.block.pipeline.api.IBlockPipelineTask
    public final boolean n1(f r100) {
        Intrinsics.checkNotNullParameter(r100, "blockPipelineConfig");
        return Intrinsics.areEqual(r100.f502480f, "moa_cot_container");
    }

    @Override // com.larus.bmhome.block.pipeline.api.IBlockPipelineTask
    public final List<Block> d3(f r100, List<Block> r101) {
        IBlockPipelineTask.a.c(r100, r101);
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.block.pipeline.api.IBlockPipelineTask
    public final List<a> k2(f r100, List<? extends a> r101) {
        Intrinsics.checkNotNullParameter(r100, "blockPipelineConfig");
        Intrinsics.checkNotNullParameter(r101, "bizModelList");
        Iterator r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        Object r103 = r102.next();
        if (((a) r103).f498145a.getBlockType() != j.A) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L4;
    L12:
        a r105 = (a) r103;
        if (r105 != null) goto L16;
        return r101;
    L16:
        return r105.i();
    L8:
        r104 = false;
        goto L9
    L11:
        r103 = null;
        goto L12
    }

    @Override // com.larus.bmhome.block.pipeline.api.IBlockPipelineTask
    public final void m2(f r100, List<Block> r101, List<? extends a> r102) {
        IBlockPipelineTask.a.a(r100, r101, r102);
    }
}
