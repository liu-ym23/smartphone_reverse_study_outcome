package com.larus.bmhome.chat.block.base;

import com.larus.im.bean.message.block.Block;
import jc8.b;
import kc8.f;
import kotlin.Metadata;
import pd6.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH&J\u001a\u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/chat/block/base/IBlockProvider;", "Lcom/bytedance/kmp/spi/IKmpService;", "providerType", "Lcom/larus/bmhome/chat/block/base/BlockProviderType;", "getProviderType", "()Lcom/larus/bmhome/chat/block/base/BlockProviderType;", "transformBlockBizModel", "Lcom/larus/bmhome/chat/block/base/BaseBlockBizModel;", "blockPipelineConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockPipelineConfig;", "parentBlock", "sourceData", "Lcom/larus/im/bean/message/block/Block;", "createBlockHolder", "Lcom/larus/bmhome/chat/block/base/BaseBlockHolder;", "blockBizModel", "block-kit-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IBlockProvider extends a {
    BlockProviderType N0();

    jc8.a W1(f r100, jc8.a r101, Block r102);

    b<? extends jc8.a> t0(jc8.a r100);
}
