package com.bytedance.ee.bear.integrator.di;

import com.bytedance.ee.bear.account.AccountModuleKt;
import com.bytedance.ee.bear.attachment.filereader.AttachmentModuleKt;
import com.bytedance.ee.bear.banner.BannerDiModuleKt;
import com.bytedance.ee.bear.bitable.BitableDIModuleKt;
import com.bytedance.ee.bear.block.BlockModuleKt;
import com.bytedance.ee.bear.doc.DocDIModuleKt;
import com.bytedance.ee.bear.docsemoji.DocsEmojiModuleKt;
import com.bytedance.ee.bear.docshost.DocsHostModuleKt;
import com.bytedance.ee.bear.document.DocumentModuleKt;
import com.bytedance.ee.bear.drive.config.di.DriveDIModuleKt;
import com.bytedance.ee.bear.drive.config.di.DrivePreviewDiModuleKt;
import com.bytedance.ee.bear.imageviewer.ImageViewerModuleKt;
import com.bytedance.ee.bear.imageviewer.edit.EditImageModuleKt;
import com.bytedance.ee.bear.integrator.b2btag.B2BTagModuleKt;
import com.bytedance.ee.bear.integrator.di.configs.preload.PreloadStrategyDIKt;
import com.bytedance.ee.bear.integrator.wiki.WikiCommonModuleKt;
import com.bytedance.ee.bear.leanmode.LeanModeModuleKt;
import com.bytedance.ee.bear.list.ListModuleKt;
import com.bytedance.ee.bear.lynx.impl.LynxDIModuleKt;
import com.bytedance.ee.bear.middleground.audio.AudioModuleKt;
import com.bytedance.ee.bear.middleground.comment.CommentModuleKt;
import com.bytedance.ee.bear.middleground.drive.cipher.CipherModuleKt;
import com.bytedance.ee.bear.middleground.feed.FeedModuleKt;
import com.bytedance.ee.bear.middleground.like.LikeModuleKt;
import com.bytedance.ee.bear.middleground.permission.PermissionDIModuleKt;
import com.bytedance.ee.bear.middleground.record.RecordModuleKt;
import com.bytedance.ee.bear.mindnote.MindNoteDIModuleKt;
import com.bytedance.ee.bear.module.ResourceUpdateModuleKt;
import com.bytedance.ee.bear.more.MoreModuleKt;
import com.bytedance.ee.bear.notification.NotificationModuleKt;
import com.bytedance.ee.bear.onboarding.OnBoardingModuleKt;
import com.bytedance.ee.bear.operation.OperationModuleKt;
import com.bytedance.ee.bear.quoto.QuotaDIModuleKt;
import com.bytedance.ee.bear.review.ReviewModuleKt;
import com.bytedance.ee.bear.rn.RnModuleKt;
import com.bytedance.ee.bear.search.SearchModuleKt;
import com.bytedance.ee.bear.share.ShareDIModuleKt;
import com.bytedance.ee.bear.templates.TemplatesModuleKt;
import com.bytedance.ee.bear.wikiv2.WikiModuleKt;
import com.bytedance.ee.space.services.SpaceDIModuleKt;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {
    public static final List<kwc.a> a = null;
    public static final List<kwc.a> b = null;
    public static final List<kwc.a> c = null;

    static {
        List<kwc.a> r0 = CollectionsKt.listOf(new kwc.a[]{PreloadStrategyDIKt.a, SpaceDIModuleKt.a, DriveDIModuleKt.a, DrivePreviewDiModuleKt.a, DocsHostModuleKt.a, LeanModeModuleKt.a, ListModuleKt.a, RecordModuleKt.a, DocumentModuleKt.a, DocDIModuleKt.a, ReviewModuleKt.a, DocsEmojiModuleKt.a, AttachmentModuleKt.a, AccountModuleKt.a, ImageViewerModuleKt.a, EditImageModuleKt.a, MoreModuleKt.a, PermissionDIModuleKt.a, BannerDiModuleKt.a, ShareDIModuleKt.a, WikiModuleKt.a, WikiCommonModuleKt.a, MindNoteDIModuleKt.a, BlockModuleKt.a, SearchModuleKt.a, BitableDIModuleKt.a, ResourceUpdateModuleKt.a, FeedModuleKt.a, CommentModuleKt.a, QuotaDIModuleKt.a, OnBoardingModuleKt.a, NotificationModuleKt.a, LynxDIModuleKt.a, TemplatesModuleKt.a, OperationModuleKt.a, CipherModuleKt.a, B2BTagModuleKt.a});
        a = r0;
        List<kwc.a> r1 = CollectionsKt.listOf(new kwc.a[]{AudioModuleKt.a, LikeModuleKt.a, RnModuleKt.a});
        b = r1;
        c = CollectionsKt.plus(r0, r1);
    }
}
