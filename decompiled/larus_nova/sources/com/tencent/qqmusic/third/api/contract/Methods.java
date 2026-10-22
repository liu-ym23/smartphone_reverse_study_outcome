package com.tencent.qqmusic.third.api.contract;

import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public interface Methods {
    void addLocalPathToFavourite(List<String> r100, IQQMusicApiCallback r101);

    void addToFavourite(List<String> r100, IQQMusicApiCallback r101);

    long getCurrTime();

    Data.Song getCurrentSong();

    int getCurrentSongIndexInList();

    String getFavouriteFolderId();

    void getFolderList(String r100, int r101, int r102, IQQMusicApiCallback r103);

    int getLoginState();

    void getLyric(long r100, IQQMusicApiCallback r101);

    void getLyricIncludeEndTime(String r100, IQQMusicApiCallback r101);

    void getLyricWithId(String r100, IQQMusicApiCallback r101);

    void getPlayList(int r100, IQQMusicApiCallback r101);

    int getPlayMode();

    int getPlaybackState();

    void getSongList(String r100, int r101, int r102, IQQMusicApiCallback r103);

    long getTotalTime();

    void getUserFolderList(String r100, String r101, String r102, int r103, int r104, IQQMusicApiCallback r105);

    void getUserSongList(String r100, String r101, String r102, int r103, int r104, IQQMusicApiCallback r105);

    void hi();

    void isFavouriteLocalPath(List<String> r100, IQQMusicApiCallback r101);

    void isFavouriteMid(List<String> r100, List<String> r101, List<String> r102, IQQMusicApiCallback r103);

    boolean isNewUser();

    int isQQMusicForeground();

    void openQQMusic();

    int pauseMusic();

    void playFolderType(String r100, int r101, int r102, IQQMusicApiCallback r103);

    void playFromChorus(boolean r100);

    int playMusic();

    void playSongId(List<String> r100, IQQMusicApiCallback r101);

    void playSongIdAtIndex(List<String> r100, int r101, IQQMusicApiCallback r102);

    void playSongLocalPath(List<String> r100, IQQMusicApiCallback r101);

    void playSongMid(List<String> r100, IQQMusicApiCallback r101);

    void playSongMidAtIndex(List<String> r100, int r101, IQQMusicApiCallback r102);

    void registerEventListener(List<String> r100, IQQMusicApiEventListener r101);

    void removeFromFavourite(List<String> r100, IQQMusicApiCallback r101);

    void removeLocalPathFromFavourite(List<String> r100, IQQMusicApiCallback r101);

    void requestAuth(String r100, IQQMusicApiCallback r101);

    int resumeMusic();

    void search(String r100, int r101, boolean r102, IQQMusicApiCallback r103);

    long seek(long r100);

    int seekBack(long r100);

    int seekForward(long r100);

    void setPlayMode(int r100);

    int setPlayModeWithRet(int r100);

    int skipToNext();

    int skipToPrevious();

    void startPcmMode(IQQMusicApiCallback r100);

    int stopMusic();

    void stopPcmMode();

    void unregisterEventListener(List<String> r100, IQQMusicApiEventListener r101);

    void voicePlay(String r100, List<String> r101, IQQMusicApiCallback r102);

    void voiceShortcut(String r100, IQQMusicApiCallback r101);
}
