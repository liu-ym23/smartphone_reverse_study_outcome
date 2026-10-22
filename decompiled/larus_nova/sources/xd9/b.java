package xd9;

import com.larus.im.bean.message.block.BlockInsertReference;
import com.larus.im.bean.message.block.BlockMetaInfoTypeEnum;
import zc9.u;

/* JADX INFO: loaded from: classes29.dex */
public final class b implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BlockInsertReference f563299a;

    @Override // zc9.u
    public final BlockInsertReference getMetaInfo() {
        return this.f563299a;
    }

    @Override // zc9.u
    public BlockMetaInfoTypeEnum getType() {
        return BlockMetaInfoTypeEnum.SUPERSCRIPT;
    }

    public b(BlockInsertReference r100) {
        this.f563299a = r100;
    }
}
